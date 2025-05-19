package com.example.connectors;
import com.example.models.Category;
import com.example.models.ListCategory;

import java.util.ArrayList;

public class CategoryConnector {
    ListCategory listCategory;

    public CategoryConnector() {
        listCategory = new ListCategory();
        listCategory.generate_sample_dataset();
    }

    public ArrayList<Category> get_all_categories() {
        if (listCategory == null) {
            listCategory = new ListCategory();
            listCategory.generate_sample_dataset();
        }
        return listCategory.getCategories();
    }
}
