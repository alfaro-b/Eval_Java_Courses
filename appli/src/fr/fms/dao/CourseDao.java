package fr.fms.dao;

import java.sql.Connection;
import java.util.List;

import fr.fms.entities.Course;

/** Interface DAO spécifique aux formations.
 * Hérite des opérations CRUD génériques définies dans Dao<Course>.
 */
public interface CourseDao extends Dao<Course> {

	/**
	 * Recherche les formations contenant un mot-clé.
	 *
	 * @param keyword mot-clé recherché
	 * @param connection connexion à la base de données
	 * @return liste des formations correspondantes
	 */
    List<Course> findByKeyword(String keyword, Connection connection);

	/**
	 * Recherche les formations par format.
	 *
	 * @param idFormat identifiant du format
	 * @param connection connexion à la base de données
	 * @return liste des formations correspondantes
	 */
    List<Course> findByFormat(int idFormat, Connection connection);
}
