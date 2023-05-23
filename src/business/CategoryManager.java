package business;

import core.logging.Logger;
import dataAccess.ProductDao;
import entities.Category;

public class CategoryManager {
    private static ProductDao productDao;
    private static Logger[] loggers;

    public CategoryManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }
    public static void add(Category category) {
        try {
            if (category.getCategoryName() == null || category.getCategoryName().isEmpty()) {
                throw new Exception("Kategori ismi boş geçilemez.");
            }

            productDao.add(category);
            for (Logger logger : loggers) {
                logger.log(category.getCategoryName());
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
