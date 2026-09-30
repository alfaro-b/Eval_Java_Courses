package fr.fms.entities;

/** Représente une ligne de commande.
 * 
 * Une ligne de commande possède une quantité, un prix au moment de la commande et une formation.
 */
public class OrderItem {


	// =========================
    // ATTRIBUTS
    // =========================
	private int quantity;
	private double price;
	private Course course;
	
    // =========================
    // CONSTRUCTEURS
    // =========================
	
	/** Crée une ligne de commande avec une quantité, un prix au moment de la commande et une formation.
	 * @param quantity quantité commandée
	 * @param price prix au moment de la comande
	 * @param course cours commandé
	 * 
	 */
	public OrderItem(int quantity, double price, Course course) {
		this.quantity = quantity;
		this.price = price;
		this.course = course;
	}
	
    // =========================
    // ACCESSEURS
    // =========================
	
	/** Récupère la quantité commandée
	 * @return quantité commandée
	 */
	public int getQuantity() {
		return quantity;
	}

	/** Enregistre la quantité commandée
	 * @param quantity quantité commandée
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/** Récupère le prix au moment de la commande
	 * @return prix au moment de la commande
	 */
	public double getPrice() {
		return price;
	}

	/** Enregistre le prix au moment de la commande
	 * @param price prix au moment de la commande
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/** Récupère la formation commandée
	 * @return formation commandée
	 */
	public Course getCourse() {
		return course;
	}

	/** Enregistre la formation commandée
	 * @param course formation commandée
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	
	// =========================
    // MÉTHODES
    // =========================
	
	/** Retourne les informations de OrderItem sous forme de chaine.
	 * @return représentation textuelle de OrderItem
	 */
	@Override
	public String toString() {
		return "OrderItem [quantity=" + quantity + ", price=" + price + ", course=" + course + "]";
	}

}
