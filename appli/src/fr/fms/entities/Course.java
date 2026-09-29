package fr.fms.entities;

import java.util.List;

/** Repésente une formation
 * 
 * Une formation possède un identifiant, un nom, une description, une durée, un prix et une liste de formats.
 */
public class Course {

	// =========================
    // ATTRIBUTS
    // =========================

	private int idCourse;
	private String name;
	private String description;
	private int duration;
	private double price;
	private List<Format> formats;
	
    // =========================
    // CONSTRUCTEUR
    // =========================
	
    /** Crée une formation avec un identifiant, un nom, une description, une durée, un prix et une liste de formats.
     * 
     * @param idCourse identifiant de la formation
     * @param name nom de la formation
     * @param description description de la formation
     * @param duration durée en jours de la formation
     * @param price prix de la formation
     * @param formats liste des formats de la formation
     */
    public Course(int idCourse, String name, String description, int duration, double price, List<Format> formats) {
		this.idCourse = idCourse;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.price = price;
		this.formats = formats;
	}
    
    /** Crée une formation avec un nom, une description, une durée, un prix et une liste de formats.
     * 
     * @param name nom de la formation
     * @param description description de la formation
     * @param duration durée en jours de la formation
     * @param price prix de la formation
     * @param formats liste des formats de la formation
     */
    public Course(String name, String description, int duration, double price, List<Format> formats) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.price = price;
		this.formats = formats;
	}
    
    // =========================
    // ACCESSEURS
    // =========================
    
	/** Récupère l'identifiant de la formation
	 * @return identifiant de la formation
	 */
	public int getIdCourse() {
		return idCourse;
	}

	/** Enregistre l'identifiant de la formation
	 * @param identifiant de la formation
	 */
	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	/** Récupère le nom de la formation
	 * @return nom de la formation
	 */
	public String getName() {
		return name;
	}

	/** Enregistre le nom de la formation
	 * @param nom de la formation
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Récupère la description de la formation
	 * @return description de la formation
	 */
	public String getDescription() {
		return description;
	}

	/** Enregistre la description de la formation
	 * @param description de la formation
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Récupère la durée de la formation
	 * @return durée de la formation
	 */
	public int getDuration() {
		return duration;
	}

	/** Enregistre la durée de la formation
	 * @param durée de la formation
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/** Récupère le prix de la formation
	 * @return prix de la formation
	 */
	public double getPrice() {
		return price;
	}

	/** Enregistre le prix de la formation
	 * @param prix de la formation
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/** Récupère la liste des formats de la formation
	 * @return liste des formats de la formation
	 */
	public List<Format> getFormats() {
		return formats;
	}

	/** Enregistre la liste des formats de la formation
	 * @param liste des formats de la formation
	 */
	public void setFormats(List<Format> formats) {
		this.formats = formats;
	}
	
	// =========================
    // MÉTHODES
    // =========================
	
	/** Retourne les informations de la formation sous forme de chaine.
	 * @return représentation textuelle de la formation
	 */
	@Override
	public String toString() {
	    return "Course [idCourse=" + idCourse
	            + ", name=" + name
	            + ", description=" + description
	            + ", duration=" + duration
	            + ", price=" + price
	            + ", formats=" + formats + "]";
	}

}
