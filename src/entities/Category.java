package entities;

public class Category {
        private String CategoryName;
        public Category(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }
}
