package fr.fms.entities;

/** Représente un type de format
 * 
 * Un format possède un nom et un identifiant
 */
public class Format {

	// =========================
    // ATTRIBUTS
    // =========================
	private int idFormat;
	private String name;
	
    // =========================
    // CONSTRUCTEURS
    // =========================
	
	/** Crée un format avec un identifiant et un nom.
	 * @param idFormat identifiant du format
	 * @param name nom du format
	 */
	public Format(int idFormat, String name) {
		this.idFormat = idFormat;
		this.name = name;
	}
	
	/** Crée un format avec un nom.
	 * @param name nom du format
	 */
	public Format(String name) {
		this.name = name;
	}
	
    // =========================
    // ACCESSEURS
    // =========================
	
	/** Récupère l'identifiant du format
	 * @return identifiant du format
	 */
	public int getIdFormat() {
		return idFormat;
	}

	/** Enregistre l'identifiant du format
	 * @param identifiant du format
	 */
	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	/** Récupère le nom du format
	 * @return nom du format
	 */
	public String getName() {
		return name;
	}

	/** Enregistre le nom du format
	 * @param nom du format
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	// =========================
    // MÉTHODES
    // =========================
	
	/** Retourne les informations du format sous forme de chaine.
	 * @return représentation textuelle du format
	 */
	@Override
	public String toString() {
		return "Format [idFormat=" + idFormat + ", name=" + name + "]";
	}
	
}
