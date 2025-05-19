package com.example.k22411csampleproduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.connectors.CategoryConnector;
import com.example.models.Category;

public class CategoryManagementActivity extends AppCompatActivity {
    ListView lvCategory;
    ArrayAdapter<Category> adapter;
    CategoryConnector connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
//        lvCategory.setOnItemLongClickListener((parent, view, position, id) -> {
//            Category selected = adapter.getItem(position);
//            adapter.remove(selected);
//            return false;
//        });
        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Category selected = adapter.getItem(position);
                Intent intent = new Intent(CategoryManagementActivity.this, ProductManagementActivity.class);
                intent.putExtra("cate_id", selected.getId());
                startActivity(intent);
            }
        });

    }

    private void addViews() {
        lvCategory = findViewById(R.id.lvCategory);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        connector = new CategoryConnector();
        adapter.addAll(connector.get_all_categories());
        lvCategory.setAdapter(adapter);
    }
}