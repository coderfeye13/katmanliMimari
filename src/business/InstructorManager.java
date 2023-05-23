package business;

import core.logging.Logger;
import dataAccess.ProductDao;
import entities.Category;
import entities.Instructor;

public class InstructorManager {
    private static ProductDao productDao;
    public static Logger[] loggers;

    public InstructorManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public static void add(Instructor instructor) {
        try {
            if (instructor.getFirstName() == null || instructor.getFirstName().isEmpty()) {
                throw new Exception("Eğitmen ismi boş geçilemez.");
            }

            productDao.add(instructor);
            for (Logger logger : loggers) {
                logger.log(instructor.getFirstName());
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
