package fr.fms.entities;

import java.time.LocalDate;
import java.util.List;

/** Représente une commande.
 * 
 * Une commande possède un identifiant, une date et une liste de lignes de commande.
 */
public class Order {

	// =========================
    // ATTRIBUTS
    // =========================
	private int idOrder;
	private LocalDate date;
	private Buyer buyer;
	private Customer customer;
	private List<OrderItem> orderItems;
	
    // =========================
    // CONSTRUCTEURS
    // =========================
	
	/** Crée une commande avec un identifiant, une date, un acheteur, un client et une liste de lignes de commande.
	 * @param idOrder identifiant de la commande
	 * @param date date de la commande
	 * @param buyer acheteur
	 * @param customer client
	 * @param orderItems liste des lignes de commande
	 * 
	 */
	public Order(int idOrder, LocalDate date, Buyer buyer, Customer customer, List<OrderItem> orderItems) {
		this.idOrder = idOrder;
		this.date = date;
		this.buyer = buyer;
		this.customer = customer;
		this.orderItems = orderItems;
	}
	
	/** Crée une commande avec une date, un acheteur, un client et une liste de lignes de commande.
	 * @param date date de la commande
	 * @param buyer acheteur
	 * @param customer client
	 * @param orderItems liste des lignes de commande
	 * 
	 */
	public Order(LocalDate date, Buyer buyer, Customer customer, List<OrderItem> orderItems) {
		this.date = date;
		this.buyer = buyer;
		this.customer = customer;
		this.orderItems = orderItems;
	}
	
    // =========================
    // ACCESSEURS
    // =========================
	
	/** Récupère l'identifiant de la commande
	 * @return identifiant de la commande
	 */
	public int getIdOrder() {
		return idOrder;
	}

	/** Enregistre l'identifiant de la commande
	 * @param idOrder identifiant de la commande
	 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	/** Récupère la date de la commande
	 * @return date de la commande
	 */
	public LocalDate getDate() {
		return date;
	}

	/** Enregistre la date de la commande
	 * @param date date de la commande
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/** Récupère l'acheteur
	 * @return l'acheteur
	 */
	public Buyer getBuyer() {
		return buyer;
	}

	/** Enregistre l'acheteur de la commande
	 * @param buyer l'acheteur
	 */
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	/** Récupère le client
	 * @return le client
	 */
	public Customer getCustomer() {
		return customer;
	}

	/** Enregistre le client
	 * @param customer le client
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/** Récupère la liste des lignes de commande
	 * @return liste des lignes de commande
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/** Enregistre la liste des lignes de commande
	 * @param orderItems liste des lignes de commande
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	// =========================
    // MÉTHODES
    // =========================
	
	/** Retourne les informations de Order sous forme de chaine.
	 * @return représentation textuelle de Order
	 */
	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", date=" + date + ", buyer=" + buyer + ", customer=" + customer
				+ ", orderItems=" + orderItems + "]";
	}


}
