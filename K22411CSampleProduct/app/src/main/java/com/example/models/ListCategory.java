package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ListCategory implements Serializable {
    private ArrayList<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category c) {
        categories.add(c);
    }

    public void generate_sample_dataset() {
        String[] names = {
                "Bánh tráng", "Snack cay", "Đồ uống", "Kẹo dẻo", "Nước chấm",
                "Bánh ngọt", "Đồ ăn vặt miền Trung", "Mì ăn liền", "Rong biển", "Đồ handmade"
        };
        for (int i = 0; i < names.length; i++) {
            Category c = new Category(i + 1, names[i], "Mô tả cho " + names[i]);
            addCategory(c);
        }
    }
//    public void generate_sample_product_dataset() {
//        Category c1 = new Category(1, "Cate 1", 110);
//        Product p1=new Product(1, "Product 1", 10, 35.5, "Đồ Trung Quốc", 200)
//    }
}
