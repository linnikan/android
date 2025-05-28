package com.example.k22411csampleproduct;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//import com.example.connectors.ProductConnector;
import com.example.models.Category;
import com.example.models.ListCategory;
import com.example.models.Product;

public class ProductManagementActivity extends AppCompatActivity {
    ArrayAdapter<Category> adapterCategory;
    Spinner spinnerCategory;
    ListCategory listCategory;
    ListView lvProduct;
    ArrayAdapter<Product> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category c = adapterCategory.getItem(i);
                displayProductsByCategory(c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Không làm gì khi không chọn danh mục

            }
        });
    }

    private void displayProductsByCategory(Category c) {
        //xóa dữ liệu cũ trong listview đi:
        adapterProduct.clear();
        //nạp mới lại dữ liệu cho adapter;
        adapterProduct.addAll(c.getProducts());
    }

    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        adapterCategory = new ArrayAdapter<>(
                ProductManagementActivity.this,
                android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        listCategory = new ListCategory();
        listCategory.generate_sample_product_dataset();
        adapterCategory.addAll(listCategory.getCategories());

        lvProduct = findViewById(R.id.lvProduct);
        adapterProduct = new ArrayAdapter<>(
                ProductManagementActivity.this,
                android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_sort_by_price) {
            Toast.makeText(ProductManagementActivity.this,
                    "Sắp xếp theo giá tăng dần", Toast.LENGTH_SHORT).show();
            // TODO: Gọi hàm sắp xếp danh sách sản phẩm theo giá

        } else if (id == R.id.menu_favorite_products) {
            Toast.makeText(ProductManagementActivity.this,
                    "Lọc sản phẩm yêu thích", Toast.LENGTH_SHORT).show();
            // TODO: Hiển thị các sản phẩm người dùng đã yêu thích

        } else if (id == R.id.menu_view_cart) {
            Toast.makeText(ProductManagementActivity.this,
                    "Xem giỏ hàng", Toast.LENGTH_SHORT).show();
            // TODO: Mở màn hình giỏ hàng

        } else if (id == R.id.menu_purchase_history) {
            Toast.makeText(ProductManagementActivity.this,
                    "Xem lịch sử mua hàng", Toast.LENGTH_SHORT).show();
            // TODO: Mở màn hình lịch sử mua hàng
        }
        return super.onOptionsItemSelected(item);
    }

}
