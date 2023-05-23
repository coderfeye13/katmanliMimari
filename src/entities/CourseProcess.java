package entities;
import business.CourseManager;
import core.logging.Logger;
import dataAccess.ProductDao;
import java.util.ArrayList;
import java.util.List;

public class CourseProcess {
    private ProductDao productDao;
    private Logger[] loggers;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setLoggers(Logger[] loggers) {
        this.loggers = loggers;
    }

    public void processCourses() {
        try {
            // Kurs bilgilerini elle girerek liste oluşturun
            List<Course> courses = new ArrayList<>();
            courses.add(new Course(1, "JAVA",120));
            courses.add(new Course(2,"C#", 120));
            courses.add(new Course(3,"C++", 140));

            // Her bir kurs için işlemi gerçekleştir
            CourseManager courseManager = new CourseManager(productDao, loggers);
            for (Course course : courses) {
                courseManager.add(course);
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}

