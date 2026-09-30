package fr.fms.entities;

/** Représente un acheteur.
 * 
 * Un acheteur possède un identifiant, un nom , un identifiant de connexion et un mot de passe.
 */
public class Buyer {
	
	// =========================
    // ATTRIBUTS
    // =========================
	private int idBuyer;
	private String name;
	private String login; 
	private String password;
	
    // =========================
    // CONSTRUCTEURS
    // =========================
	
	/** Crée un acheteur avec un identifiant, un nom , un identifiant de connexion et un mot de passe.
	 * @param idBuyer identifiant de l'acheteur
	 * @param name nom de l'acheteur
	 * @param login identifiant de connexion de l'acheteur
	 * @param password mot de passe de l'acheteur
	 */
	public Buyer(int idBuyer, String name, String login, String password) {
		this.idBuyer = idBuyer;
		this.name = name;
		this.login = login;
		this.password = password;
	}
	
	/** Crée un acheteur avec un nom , un identifiant de connexion et un mot de passe.
	 * @param name nom de l'acheteur
	 * @param login identifiant de connexion de l'acheteur
	 * @param password mot de passe de l'acheteur
	 */
	public Buyer(String name, String login, String password) {
	    this.name = name;
	    this.login = login;
	    this.password = password;
	}
	
    // =========================
    // ACCESSEURS
    // =========================
	
	/** Récupère l'identifiant de l'acheteur
	 * @return identifiant de l'acheteur
	 */
	public int getIdBuyer() {
		return idBuyer;
	}

	/** Enregistre l'identifiant de l'acheteur
	 * @param idBuyer identifiant de l'acheteur
	 */
	public void setIdBuyer(int idBuyer) {
		this.idBuyer = idBuyer;
	}

	/** Récupère le nom de l'acheteur
	 * @return nom de l'acheteur
	 */
	public String getName() {
		return name;
	}

	/** Enregistre le nom de l'acheteur
	 * @param name nom de l'acheteur
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Récupère l'identifiant de connexion de l'acheteur
	 * @return identifiant de connexion de l'acheteur
	 */
	public String getLogin() {
		return login;
	}

	/** Enregistre l'identifiant de connexion de l'acheteur
	 * @param login identifiant de connexion de l'acheteur
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/** Récupère le mot de passe de l'acheteur
	 * @return mot de passe de l'acheteur
	 */
	public String getPassword() {
		return password;
	}

	/** Enregistre le mot de passe de l'acheteur
	 * @param password mot de passe de l'acheteur
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	// =========================
    // MÉTHODES
    // =========================
	
	/** Retourne les informations de l'acheteur sous forme de chaine.
	 * @return représentation textuelle de l'acheteur
	 */
	@Override
	public String toString() {
		return "Buyer [idBuyer=" + idBuyer + ", name=" + name + ", login=" + login + "]";
	}
}
