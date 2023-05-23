package dataAccess;

import entities.Category;
import entities.Course;
import entities.Instructor;

public interface ProductDao {
    void add(Instructor instructor);
    void add(Course course);

    void add(Category category);
}