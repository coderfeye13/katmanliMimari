package dataAccess;

import entities.Category;
import entities.Course;
import entities.Instructor;

public class jdbcProductDao implements ProductDao {
    public void add(Category category) {
        System.out.println("JDBC ile veri tabanına eklendi : " + category.getCategoryName());
    }

    public void add(Course course) {
        System.out.println("JDBC ile veri tabanına eklendi : " + course.getCourseName());
    }

    public void add(Instructor instructor) {
        System.out.println("JDBC ile veri tabanına eklendi : " + instructor.getFirstName() + " " + instructor.getLastName());
    }
}