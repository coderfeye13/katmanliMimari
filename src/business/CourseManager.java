package business;

import core.logging.Logger;
import dataAccess.ProductDao;
import entities.Course;

public class CourseManager {
    private static ProductDao productDao;
    private static Logger[] loggers;

    public CourseManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public static void add(Course course) throws Exception{
        //iş kuralları
        if (course.getUnitPrice() < 10) {
            throw new Exception("Ürün fiyatı 10 dan küçük olamaz");
        }

        productDao.add(course);
        for (Logger logger:loggers) {
            logger.log(course.getCourseName());
        }
    }
}
