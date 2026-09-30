package fr.fms.entities;

/** Représente un client.
 * 
 * Un client possède un identifiant, un nom , un prénom, un email, une adresse et un numéro de téléphone.
 */
public class Customer {
	
	// =========================
    // ATTRIBUTS
    // =========================
	private int idCustomer;
	private String lastName;
	private String firstName;
	private String email; 
	private String address;
	private String phone;
	
    // =========================
    // CONSTRUCTEURS
    // =========================
	
	/** Crée un client avec un identifiant, un nom , un prénom, un email, une adresse et un numéro de téléphone.
	 * @param idCustomer identifiant du client
	 * @param lastName nom du client
	 * @param firstName prénom du client
	 * @param email mail du client
	 * @param address adresse du client
	 * @param phone téléphone du client
	 */
	public Customer(int idCustomer, String lastName, String firstName, String email, String address, String phone) {
		this.idCustomer = idCustomer;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	/** Crée un client avec un nom , un prénom, un email, une adresse et un numéro de téléphone.
	 * @param lastName nom du client
	 * @param firstName prénom du client
	 * @param email mail du client
	 * @param address adresse du client
	 * @param phone téléphone du client
	 */
	public Customer(String lastName, String firstName, String email, String address, String phone) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
    // =========================
    // ACCESSEURS
    // =========================
	
	/** Récupère l'identifiant du client
	 * @return identifiant du client
	 */
	public int getIdCustomer() {
		return idCustomer;
	}

	/** Enregistre l'identifiant du client
	 * @param idCustomer identifiant du client
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	/** Récupère le nom du client
	 * @return nom du client
	 */
	public String getLastName() {
		return lastName;
	}

	/** Enregistre le nom du client
	 * @param lastName nom du client
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Récupère le prénom du client
	 * @return prénom du client
	 */
	public String getFirstName() {
		return firstName;
	}

	/** Enregistre le prénom du client
	 * @param firstName prénom du client
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Récupère le mail du client
	 * @return mail du client
	 */
	public String getEmail() {
		return email;
	}

	/** Enregistre le mail du client
	 * @param email mail du client
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** Récupère l'adresse du client
	 * @return adresse du client
	 */
	public String getAddress() {
		return address;
	}

	/** Enregistre l'adresse du client
	 * @param address adresse du client
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/** Récupère le numéro de téléphone du client
	 * @return numéro de téléphone du client
	 */
	public String getPhone() {
		return phone;
	}

	/** Enregistre le numéro de téléphone du client
	 * @param phone numéro de téléphone du client
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// =========================
    // MÉTHODES
    // =========================
	
	/** Retourne les informations du client sous forme de chaine.
	 * @return représentation textuelle du client
	 */
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", lastName=" + lastName + ", firstName=" + firstName + ", email="
				+ email + ", address=" + address + ", phone=" + phone + "]";
	}
}
