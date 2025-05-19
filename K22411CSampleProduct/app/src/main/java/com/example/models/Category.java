package com.example.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private int id;
    private String name;
//    private int image_id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return description;
    }

    public void setDiscription(String discription) {
        this.description = discription;
    }

    public Category() {
//        products=new ArrayList<>();
    }
    public Category(int id, String name, String discription) {
        this.id = id;
        this.name = name;
//        this.image_id=image_id;
        this.description = discription;
//        products=new ArrayList<>();
    }
    @NonNull
    @Override
    public String toString() {
        return id + " - " + name + "\n" + description;
    }

//    public void addProduct(Product p);
//    {
//        products.add(p);
//    }
}
