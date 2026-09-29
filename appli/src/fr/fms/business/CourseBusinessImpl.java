package fr.fms.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import fr.fms.dao.CourseDao;
import fr.fms.dao.FormatDao;
import fr.fms.entities.Course;

/** Implementation de la couche métier pour la gestion des formations.
 * Orchestre les DAO CourseDao et FormatDao.
 */
public class CourseBusinessImpl implements CourseBusiness {
	
	// =========================
    // ATTRIBUTS
    // =========================
	private final CourseDao courseDao;
	private final FormatDao formatDao;
	private Connection connection;
	
	
    // =========================
    // CONSTRUCTEUR
    // =========================
	
    public CourseBusinessImpl(CourseDao courseDao, FormatDao formatDao) {
        this.courseDao = courseDao;
        this.formatDao = formatDao;
        this.connection = this.initConnection();
    }


	// =========================
    // MÉTHODES
    // =========================
    
	/** Crée la connexion à la base de données.
	 * @return connexion à la base de données.
	 */
	private Connection initConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(ClassNotFoundException e) {
    			e.printStackTrace();
        }
		
		String url = "jdbc:mariadb://localhost:3306/courses_sales";
		String login = "courses_user";
		String password = "MotDePasseUser";
		
		try {
			return connection = DriverManager.getConnection(url,login,password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
    
	/** Récupère toutes les formations avec leurs formats.
	 * @return liste de toutes les formations
	 */
	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = courseDao.findAll(connection);
		
		for(Course course : courses) {
			course.setFormats(formatDao.findByCourse(course.getIdCourse(), connection));
		}
		return courses;
	}

    /** Recherche les formations contenant un mot clé.
     * @param keyword mot clé recherché
     * @return liste des formations correspondantes
     */
	@Override
	public List<Course> findCoursesByKeyword(String keyword) {
	    List<Course> courses = courseDao.findByKeyword(keyword, connection);

	    for (Course course : courses) {
	        course.setFormats(
	            formatDao.findByCourse(course.getIdCourse(), connection)
	        );
	    }

	    return courses;
	}

    /** Recherche les formations disponibles dans un format donné.
     * @param idFormat identifiant du format
     * @return liste des formations correspondantes
     */
	@Override
	public List<Course> findCoursesByFormat(int idFormat) {
		// TODO Auto-generated method stub
		return null;
	}

    /** Ferme la connexion à la base de données.
     * 
     */
	@Override
    public void closeConnection() {
		try {
			this.connection.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
}

}
