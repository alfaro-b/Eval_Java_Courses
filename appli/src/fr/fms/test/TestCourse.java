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

        for (Course course : business.getAllCourses()) {
            System.out.println(course);
        }

        business.closeConnection();
    }
}