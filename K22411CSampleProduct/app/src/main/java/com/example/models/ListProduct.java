package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListProduct implements Serializable {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void generate_sample_dataset() {
        String[] names = {
                "Bánh tráng tôm", "Snack lẩu Thái", "Nước suối", "Kẹo dẻo chanh dây",
                "Nước mắm me", "Bánh su kem", "Chả bò Đà Nẵng", "Mì cay Hàn Quốc",
                "Rong biển cháy tỏi", "Móc khóa handmade"
        };

//        int[] cateIds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int productId = 1;
        Random random = new Random();
        for (int cateId = 1; cateId <= 10; cateId++) {
            for (int i = 1; i <= 10; i++) {// 10 sản phẩm mỗi category
                Product p = new Product();
                p.setId(productId++);
                p.setName(names[cateId - 1] + " #" + i);
                p.setQuantity(random.nextInt(100) + 1);
                p.setPrice(5 + random.nextDouble() * 45); // giá từ 5 đến 50
                p.setCate_id(cateId);
                p.setDescription("Mô tả sản phẩm: " + names[cateId - 1] + " #" + i);
                addProduct(p);
            }
        }
    }
}
