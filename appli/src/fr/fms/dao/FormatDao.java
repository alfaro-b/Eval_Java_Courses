package fr.fms.dao;

import java.sql.Connection;
import java.util.List;

import fr.fms.entities.Format;

/** Interface DAO spécifique aux formats.
 * Hérite des opérations CRUD génériques définies dans Dao<Format>.
 */
public interface FormatDao extends Dao<Format> {

	/**
	 * Recherche les formats par formation.
	 *
	 * @param idCourse identifiant de la formation
	 * @param connection connexion à la base de données
	 * @return liste des formats correspondants
	 */
    List<Format> findByCourse(int idCourse, Connection connection);
}
