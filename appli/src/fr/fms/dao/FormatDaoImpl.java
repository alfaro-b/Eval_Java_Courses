package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.fms.entities.Format;

/** Implémentation du DAO permettant d'accéder aux données des formats.
 * Cette classe contient les opérations CRUD définies dans Dao<Format>
 * ainsi que les recherches spécifiques définies dans FormatDao.
 */
public class FormatDaoImpl implements FormatDao{

	/** Recherche un format par son identifiant.
	 *
	 * @param id identifiant du format
	 * @param connection connexion à la base de données
	 * @return format correspondant ou null s'il n'existe pas
	 */
	@Override
	public Format findById(int id, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Récupère tous les formats présents dans la base de données.
	 *
	 * @param connection connexion à la base de données
	 * @return liste de tous les formats
	 */
	@Override
	public List<Format> findAll(Connection connection) {
		List<Format> formats = new ArrayList<>();

	    String sql = "SELECT id_format, name "
	               + "FROM format "
	               + "ORDER BY id_format";

	    try (
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery()
	    ) {

	        while (rs.next()) {

	            Format format = new Format(
	                rs.getInt("id_format"),
	                rs.getString("name")
	            );

	            formats.add(format);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return formats;
	}

	/** Enregistre un nouveau format dans la base de données.
	 *
	 * @param format format à enregistrer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void save(Format format, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Met à jour un format existant.
	 *
	 * @param format format contenant les nouvelles informations
	 * @param connection connexion à la base de données
	 */
	@Override
	public void update(Format format, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Supprime un format à partir de son identifiant.
	 *
	 * @param id identifiant du format à supprimer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void delete(int id, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Recherche les formats disponibles dans une formation donnée.
	 *
	 * @param idFormation identifiant de la formation recherchée
	 * @param connection connexion à la base de données
	 * @return liste des formats correspondants
	 */
	@Override
	public List<Format> findByCourse(int idCourse, Connection connection) {
		List<Format> formats = new ArrayList<>();
		
	    String sql = "SELECT format.id_format, format.name "
	               + "FROM format "
	               + "JOIN course_format ON format.id_format = course_format.id_format "
	               + "WHERE course_format.id_course = ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setInt(1, idCourse);

	        try (ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                Format format = new Format(
	                    rs.getInt("id_format"),
	                    rs.getString("name")
	                );

	                formats.add(format);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return formats;
	}

}
