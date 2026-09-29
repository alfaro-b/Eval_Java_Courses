package fr.fms.business;

import java.util.List;

import fr.fms.entities.Course;

/** Interface métier pour la gestion des formations.
 * Définit les fonctionnalités accessibles depuis la couche applications.
 */
public interface CourseBusiness {
	
    /** Récupère toutes les formations avec leurs formats.
     * @return liste de toutes les formations
     */
    List<Course> getAllCourses();

    
    /** Recherche les formations contenant un mot clé.
     * @param keyword mot clé recherché
     * @return liste des formations correspondantes
     */
    List<Course> findCoursesByKeyword(String keyword);

    
    /** Recherche les formations disponibles dans un format donné.
     * @param idFormat identifiant du format
     * @return liste des formations correspondantes
     */
    List<Course> findCoursesByFormat(int idFormat);

    /** Ferme la connexion à la base de données.
     * 
     */
    void closeConnection();
}
