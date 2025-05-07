package com.example.k22411c_firstdegree;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //    KhAI BÁO CÁC BIẾN ĐỂ QUẢN LÝ CÁC Ô NHỚ CỦA CÁC VIEW
    EditText edtCoefficientA;
    EditText edtCoefficientB;
    TextView txtResult, tvA, tvB;
     Button btnSolve, btnNext, btnExit, btnEN, btnVI, btnFR, btnES;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtCoefficientA=findViewById(R.id.edtCoefficientA);
        edtCoefficientB=findViewById(R.id.edtCoefficientB);
        txtResult=findViewById(R.id.txtResult);

        // thêm các thành phần cần cập nhật ngôn ngữ
        tvA = findViewById(R.id.textView3);
        tvB = findViewById(R.id.textView4);
        btnSolve = findViewById(R.id.button);
        btnNext = findViewById(R.id.button2);
        btnExit = findViewById(R.id.button3);
        btnEN = findViewById(R.id.btnEN);
        btnVI = findViewById(R.id.btnVI);
        btnFR = findViewById(R.id.btnFR);
        btnES = findViewById(R.id.btnES);

    }

    public void do_solution(View view) {
//        Lấy hệ số a trên giao diện
        String hsa=edtCoefficientA.getText().toString();
        double a=Double.parseDouble(hsa);
//        Lấy hệ số b trên giao diện
        double b=Double.parseDouble(edtCoefficientB.getText().toString());

        if (a==0 && b==0)
        {
            txtResult.setText(getResources().getText(R.string.title_infinity));
        }
        else if(a==0 && b!=0)
        {
            txtResult.setText(getResources().getText(R.string.title_no_solution));
        }
        else
        {
            double x=-b/a;
            txtResult.setText("x="+x);
        }

    }

    public void do_next(View view) {
        edtCoefficientA.setText("");
        edtCoefficientB.setText("");
        txtResult.setText("");
        //di chuyển con trỏ nập liệu vào HSA để nhập cho lẹ
        edtCoefficientA.requestFocus();
    }

    public void do_exit(View view) {
        finish();
    }
    public void changeLanguage(View view) {
        int id = view.getId();
        if (id == R.id.btnEN) {
            tvA.setText("Coefficient a:");
            tvB.setText("Coefficient b:");
            btnSolve.setText("Solution");
            btnNext.setText("Next");
            btnExit.setText("Exit");
            txtResult.setText("Result:");
        } else if (id == R.id.btnVI) {
            tvA.setText("Hệ số a:");
            tvB.setText("Hệ số b:");
            btnSolve.setText("Giải");
            btnNext.setText("Tiếp");
            btnExit.setText("Thoát");
            txtResult.setText("Kết quả:");
        } else if (id == R.id.btnFR) {
            tvA.setText("Coefficient a:");
            tvB.setText("Coefficient b:");
            btnSolve.setText("Résoudre");
            btnNext.setText("Continuer");
            btnExit.setText("Quitter");
            txtResult.setText("Résultat:");
        } else if (id == R.id.btnES) {
            tvA.setText("Coeficiente a:");
            tvB.setText("Coeficiente b:");
            btnSolve.setText("Resolver");
            btnNext.setText("Continuar");
            btnExit.setText("Salir");
            txtResult.setText("Resultado:");
        }
    }
}




