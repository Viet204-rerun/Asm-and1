package com.example.asm_ph32598.Asm;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.asm_ph32598.R;

public class giaodien4 extends ComponentActivity {
    TextView tv1 ,tv2 ,tv3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien4);
        tv2 = findViewById(R.id.nhanvien);
        tv3 = findViewById(R.id.thoat);
    }

    public void myClickFunction(View view) {
        Intent intent = new Intent(giaodien4.this,giaodien5.class);
        startActivity(intent);
    }

    public void myClickFunction1(View view) {
        Intent intent = new Intent(giaodien4.this,giaodien6.class);
        startActivity(intent);
    }

    public void myClickFunction2(View view) {
            finishAffinity(); // Kết thúc tất cả các Activity trong stack
            System.exit(0); // Đóng ứng dụng

    }
}