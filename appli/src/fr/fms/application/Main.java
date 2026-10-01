package fr.fms.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.fms.business.CourseBusiness;
import fr.fms.business.CourseBusinessImpl;
import fr.fms.business.OrderBusiness;
import fr.fms.business.OrderBusinessImpl;
import fr.fms.dao.BuyerDao;
import fr.fms.dao.BuyerDaoImpl;
import fr.fms.dao.CourseDao;
import fr.fms.dao.CourseDaoImpl;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.CustomerDaoImpl;
import fr.fms.dao.FormatDao;
import fr.fms.dao.FormatDaoImpl;
import fr.fms.dao.OrderDao;
import fr.fms.dao.OrderDaoImpl;
import fr.fms.dao.OrderItemDao;
import fr.fms.dao.OrderItemDaoImpl;
import fr.fms.entities.Buyer;
import fr.fms.entities.Cart;
import fr.fms.entities.Course;
import fr.fms.entities.Format;

/** Point d'entrée de l'application de gestion des formations.
 * Permet à l'utilisateur d'accéder aux différentes fonctionnalités disponibles depuis le menu principal.
 */
public class Main {

	/** Lance l'application et gère la navigation dans le menu principal.
	 * @param args arguments de la ligne de commande.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Dépendances pour la gestion des formations
		CourseDao courseDao = new CourseDaoImpl();
		FormatDao formatDao = new FormatDaoImpl();

		CourseBusiness courseBusiness = new CourseBusinessImpl(courseDao, formatDao);
		
		// Dépendances pour la gestion des commandes
		BuyerDao buyerDao = new BuyerDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();
		OrderItemDao orderItemDao = new OrderItemDaoImpl();

		OrderBusiness orderBusiness = new OrderBusinessImpl(customerDao,buyerDao,orderItemDao,orderDao);

		// Panier conservé en mémoire pendant l'exécution de l'application
		Cart cart = new Cart();
		
		// Acheteur actuellement connecté, null si aucun utilisateur n'est connecté
		Buyer connectedBuyer = null;
		
		boolean running = true;

		while (running) {

			// Menu principal de l'application
			displayMenu();
			
			try {
				int choice = scanner.nextInt();
				scanner.nextLine();
	
			    switch (choice) {
			        case 1:
			        	// Affichage de toutes les formations
			            displayCourses(courseBusiness.getAllCourses());
			            break;
	
			        case 2:
			            // Affichage des formations suite à une recherche par mot clé
			        	System.out.println("\n===== RECHERCHE PAR MOT CLE =====");
			    	    System.out.println("Saisissez le mot recherché : ");
			    	    String keyword = scanner.nextLine();
			    	    System.out.println("Voici la liste des formations contenant '" + keyword + "' : ");
			    	    try {
			            displayCourses(courseBusiness.findCoursesByKeyword(keyword));
			    	    } catch(IllegalArgumentException e) {
			    	    	System.out.println(e.getMessage());
			    	    }
			            break;
	
			        case 3:
			            // Affichage des formations en fonction du format
			        	List<Format> formats = courseBusiness.getAllFormats();
			        	
			        	System.out.println("\n===== RECHERCHE PAR FORMAT =====");
			        	
			    	    for (Format format : formats) {
			    	        System.out.println(format.getIdFormat() + " - " + format.getName());
			    	    }
			    	    
			    	    boolean validFormat = false;
			    	    
			    	    while (!validFormat) {
				    	    System.out.println("Quelles formations voulez vous afficher? (Choisissez le n°)");
				    	    
				    	    try {
				    	    	int selectedFormatId = scanner.nextInt();
				    	    	scanner.nextLine();
				    	    	
				    	    	// Vérifie que l'identifiant saisi correspond à un format existant
				    	    	boolean formatExists = false;
				    	    	
				    	    	for (Format format : formats) {
				    	    		if(format.getIdFormat() == selectedFormatId) {
				    	    			formatExists = true;
				    	    			break;
				    	    		}
				    	    	}
				    	    	// Si aucun format ne correspond à l'identifiant saisi, on redemande
				    	    	if (formatExists == false) {
				    	    		System.out.println("Format invalide. Veuillez réessayer.");
				    	    		continue;
				    	    	}
				    	    	
				    	    	System.out.println("Voici la liste des formations : ");
				    	    	displayCourses(courseBusiness.findCoursesByFormat(selectedFormatId));
				    	    	
				    	    	validFormat = true;
				    	    	
				    	    } catch (InputMismatchException e) {
				    	        System.out.println("Veuillez saisir un numéro de format valide.");
				    	        scanner.nextLine();
				    	    }
			    	    }
			    	    
			            break;
	
			        case 0:
			            running = false;
			            break;
	
			        default:
			            System.out.println("Choix invalide.");
			    }
			    
			} catch (InputMismatchException e) {
		        System.out.println("Veuillez saisir un nombre valide.");
		        scanner.nextLine();
			}
		}

		courseBusiness.closeConnection();
		orderBusiness.closeConnection();
		scanner.close();

	}
	
	// =========================
    // MÉTHODES
    // =========================
	
	/** Affiche le menu principal de l'application
	 * 
	 */
	private static void displayMenu() {
	    System.out.println("\n===== GESTION DES FORMATIONS =====");
	    System.out.println("1 - Afficher toutes les formations");
	    System.out.println("2 - Rechercher une formation par mot-clé");
	    System.out.println("3 - Afficher les formations par format");
	    System.out.println("0 - Quitter");
	    System.out.print("Votre choix : ");
	}
	
	/** Affiche une liste de formations
	 * @param courses liste des formations à afficher
	 */
	private static void displayCourses(List<Course> courses) {
		
		if (courses.isEmpty()) {
			System.out.println("Aucune formation trouvée");
			return;
		}
		
	    for (Course course : courses) {
	        System.out.println("----------------------------------");
	        System.out.println(course.getName());
	        System.out.println("Description : " + course.getDescription());
	        System.out.println("Durée : " + course.getDuration() + " jours");
	        System.out.println("Prix : " + course.getPrice() + " €");

	        List<String> formatNames = new ArrayList<>();
	        for (Format format : course.getFormats()) {
	            formatNames.add(format.getName());
	        }
	        System.out.println("Formats : " + String.join(", ", formatNames));

	        System.out.println();
	    }
	}
}
