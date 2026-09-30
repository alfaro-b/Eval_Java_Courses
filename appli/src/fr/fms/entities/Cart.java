package fr.fms.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Représente un panier contenant les formations sélectionnées.
 * Le panier est conservé en mémoire et contient une liste de lignes de commande.
 */
public class Cart {
	
	// =========================
    // ATTRIBUT
    // =========================
	private List<OrderItem> items;

    // =========================
    // CONSTRUCTEUR
    // =========================
	
	/** Crée un panier vide.
	 */
	public Cart() {
		this.items = new ArrayList<>();
	}

	// =========================
	// MÉTHODES
	// =========================

	/** Ajoute une formation au panier avec son prix et la quantité voulue.
	 * @param course formation
	 * @param quantity quantité voulue
	 */
	public void addCourse(Course course, int quantity) {
		
		if (quantity <= 0) {
			throw new IllegalArgumentException("La quantité doit être supérieure à 0.");
		}
		
		boolean found = false;
		double price = course.getPrice();
		
		// Si la formation est déjà dans le panier, on modifie la quantité
		for (OrderItem orderItem : items) {
			if (orderItem.getCourse().getIdCourse() == course.getIdCourse()) {
				orderItem.setQuantity(orderItem.getQuantity() + quantity);
				found = true;
				break;
			}
		}
		
		// Si la formation n'est pas dans le panier, on crée une nouvelle ligne
		if(found == false) {
			items.add(new OrderItem(quantity, price, course));
		}
	}
	
	/** Retire une formation du panier ou diminue sa quantité
	 * @param course formation à retirer
	 * @param quantity quantité à retirer
	 */
	public void removeCourse(Course course, int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("La quantité doit être supérieure à 0.");
		}
		
		boolean found = false;
		
		// Si la formation est bien dans le panier, on modifie la quantité
		
		// Utilisation d'un Iterator pour pouvoir supprimer un élément pendant le parcours de la liste
		Iterator<OrderItem> iterator = items.iterator();

		while (iterator.hasNext()) {
		    OrderItem orderItem = iterator.next();

		    if (orderItem.getCourse().getIdCourse() == course.getIdCourse()) {

		        if (orderItem.getQuantity() > quantity) {
		            orderItem.setQuantity(orderItem.getQuantity() - quantity);
		        } else {
		            iterator.remove();
		        }

				found = true;
				break;
			}
		}
		
		// Si la formation n'est pas dans le panier
		if(found == false) {
			System.out.println("La formation ne figure pas dans le panier actuel.");
		}
	}
	
	/** Récupère les lignes présentes dans le panier.
	 * @return liste des lignes du panier
	 */
	public List<OrderItem> getItems() {
		return items;
	}
	
	/**  Vérifie si le panier est vide
	 * @return true si le panier est vide, sinon false
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
}
