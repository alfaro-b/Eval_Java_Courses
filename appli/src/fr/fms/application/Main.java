package fr.fms.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.fms.business.CourseBusiness;
import fr.fms.business.CourseBusinessImpl;
import fr.fms.dao.CourseDao;
import fr.fms.dao.CourseDaoImpl;
import fr.fms.dao.FormatDao;
import fr.fms.dao.FormatDaoImpl;
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

		CourseDao courseDao = new CourseDaoImpl();
		FormatDao formatDao = new FormatDaoImpl();

		CourseBusiness business = new CourseBusinessImpl(courseDao, formatDao);

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
			            displayCourses(business.getAllCourses());
			            break;
	
			        case 2:
			            // Affichage des formations suite à une recherche par mot clé
			        	System.out.println("\n===== RECHERCHE PAR MOT CLE =====");
			    	    System.out.println("Saisissez le mot recherché : ");
			    	    String keyword = scanner.nextLine();
			    	    System.out.println("Voici la liste des formations contenant '" + keyword + "' : ");
			            displayCourses(business.findCoursesByKeyword(keyword));
			            break;
	
			        case 3:
			            // Affichage des formations en fonction du format
			        	List<Format> formats = business.getAllFormats();
			        	System.out.println("\n===== RECHERCHE PAR FORMAT =====");
			    	    for (Format format : formats) {
			    	        System.out.println(format.getIdFormat() + " - " + format.getName());
			    	    }
			    	    System.out.println("Quelles formations voulez vous afficher? (Choisissez le n°)");
			    	    int selectedFormatId = scanner.nextInt();
			    	    scanner.nextLine();
			    	    System.out.println("Voici la liste des formations : ");
			    	    displayCourses(business.findCoursesByFormat(selectedFormatId));
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

		business.closeConnection();
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
