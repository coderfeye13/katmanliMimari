package entities;

import business.InstructorManager;
import core.logging.Logger;
import dataAccess.ProductDao;

import java.util.ArrayList;
import java.util.List;

public class InstructorProcess {
    private static ProductDao productDao;
    private static Logger[] loggers;

    public static void processInstructors() {
        InstructorManager instructorManager = new InstructorManager(productDao, loggers);

        try {
            // Eğitmen bilgilerini elle girerek liste oluşturun
            List<Instructor> instructors = new ArrayList<>();
            instructors.add(new Instructor(1, "Engin", "Demiroğ"));
            instructors.add(new Instructor(2, "Furkan", "Yılmaz"));

            // Her bir eğitmen için işlemi gerçekleştir
            for (Instructor instructor : instructors) {
                instructorManager.add(instructor);
            }

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public static void setProductDao(ProductDao productDao) {
        InstructorProcess.productDao = productDao;

        // InstructorManager örneği oluşturulduğunda productDao değerini güncelle
        if (productDao != null) {
            InstructorManager instructorManager = new InstructorManager(productDao, loggers);
        }
    }

    public static void setLoggers(Logger[] loggers) {
        InstructorProcess.loggers = loggers;
    }
}




