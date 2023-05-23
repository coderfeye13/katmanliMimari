package entities;
import business.CategoryManager;
import core.logging.Logger;
import dataAccess.ProductDao;
import java.util.ArrayList;
import java.util.List;
public class CategoryProcess {
    private ProductDao productDao;
    private Logger[] loggers;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setLoggers(Logger[] loggers) {
        this.loggers = loggers;
    }

    public void processCategories() {
        try {
            // Kategori bilgilerini elle girerek liste oluşturun
            List<Category> categories = new ArrayList<>();
            categories.add(new Category("Java"));
            categories.add(new Category("C#"));

            // Her bir kategori için işlemi gerçekleştir
            CategoryManager categoryManager = new CategoryManager(productDao, loggers);
            for (Category category : categories) {
                CategoryManager.add(category);
            }

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
