package fr.fms.test;

import fr.fms.business.CourseBusiness;
import fr.fms.business.CourseBusinessImpl;
import fr.fms.dao.CourseDao;
import fr.fms.dao.CourseDaoImpl;
import fr.fms.dao.FormatDao;
import fr.fms.dao.FormatDaoImpl;
import fr.fms.entities.Course;

public class TestCourse {

    public static void main(String[] args) {

        CourseDao courseDao = new CourseDaoImpl();
        FormatDao formatDao = new FormatDaoImpl();

        CourseBusiness business = new CourseBusinessImpl(courseDao, formatDao);

        // Affiche toutes les formations
		System.out.println("\n----- Test : toutes les formations -----");
        for (Course course : business.getAllCourses()) {
            System.out.println(course);
        }
        
        // Affiche les formations avec mot clé (Java dans ex.)
		System.out.println("\n----- Test : toutes les formations avec mot clé Java -----");
        for (Course course : business.findCoursesByKeyword("Java")) {
            System.out.println(course);
        }
        
        // Affiche les formations en fonction de leur format
		System.out.println("\n----- Test : toutes les formations en fonction du format -----");
        for (Course course : business.findCoursesByFormat(1)) {
            System.out.println(course);
        }
        
        business.closeConnection();
    }
}