package com.example.k22411csampleproduct;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.connectors.ProductConnector;
import com.example.models.Product;

public class ProductManagementActivity extends AppCompatActivity {
    ListView lvProduct;
    ArrayAdapter<Product> adapter;
    ProductConnector connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);

        lvProduct = findViewById(R.id.lvProduct);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        connector = new ProductConnector();

        // Lấy cate_id từ intent
        int cateId = getIntent().getIntExtra("cate_id", -1);
        if (cateId != -1) {
            adapter.addAll(connector.get_products_by_category(cateId));
        }

        lvProduct.setAdapter(adapter);
    }
}
