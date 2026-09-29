package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.fms.entities.Course;
import fr.fms.entities.Format;

/** Implémentation du DAO permettant d'accéder aux données des formations.
 * Cette classe contient les opérations CRUD définies dans Dao<Course>
 * ainsi que les recherches spécifiques définies dans CourseDao.
 */
public class CourseDaoImpl implements CourseDao{

	/** Recherche une formation par son identifiant.
	 *
	 * @param id identifiant de la formation
	 * @param connection connexion à la base de données
	 * @return formation correspondante ou null si elle n'existe pas
	 */
	@Override
	public Course findById(int id, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Récupère toutes les formations présentes dans la base de données.
	 *
	 * @param connection connexion à la base de données
	 * @return liste de toutes les formations
	 */
	@Override
	public List<Course> findAll(Connection connection) {
		List<Course> courses = new ArrayList<>();

	    String sql = "SELECT id_course, name, description, duration, price "
	               + "FROM course "
	               + "ORDER BY id_course";

	    try (
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery()
	    ) {

	        while (rs.next()) {

	            Course course = new Course(
	                rs.getInt("id_course"),
	                rs.getString("name"),
	                rs.getString("description"),
	                rs.getInt("duration"),
	                rs.getDouble("price"),
	                new ArrayList<Format>()
	            );

	            courses.add(course);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return courses;
	}

	/** Enregistre une nouvelle formation dans la base de données.
	 *
	 * @param obj formation à enregistrer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void save(Course course, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Met à jour une formation existante.
	 *
	 * @param obj formation contenant les nouvelles informations
	 * @param connection connexion à la base de données
	 */
	@Override
	public void update(Course course, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Supprime une formation à partir de son identifiant.
	 *
	 * @param id identifiant de la formation à supprimer
	 * @param connection connexion à la base de données
	 */
	@Override
	public void delete(int id, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	/** Recherche les formations contenant un mot-clé.
	 *
	 * @param keyword mot-clé recherché
	 * @param connection connexion à la base de données
	 * @return liste des formations correspondantes
	 */
	@Override
	public List<Course> findByKeyword(String keyword, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Recherche les formations disponibles dans un format donné.
	 *
	 * @param idFormat identifiant du format recherché
	 * @param connection connexion à la base de données
	 * @return liste des formations correspondantes
	 */
	@Override
	public List<Course> findByFormat(int idFormat, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

}
