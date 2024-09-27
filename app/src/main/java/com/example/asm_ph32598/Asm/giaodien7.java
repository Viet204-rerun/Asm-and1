package com.example.asm_ph32598.Asm;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asm_ph32598.R;

public class giaodien7 extends ComponentActivity {
    TextView tv1;
    EditText edtmanv,edttennv,edtphongban;
    Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien7);
        tv1 = findViewById(R.id.themnv);
        edtmanv = findViewById(R.id.manv);
        edttennv =findViewById(R.id.tennv);
        edtphongban =findViewById(R.id.phongban);
        btn1 = findViewById(R.id.btnsubmit);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation);
        tv1.startAnimation(animation);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("ma_nv",edtmanv.getText().toString());
                bundle.putString("ten_nv",edttennv.getText().toString());
                bundle.putString("phong_ban",edtphongban.getText().toString());
                intent.putExtras(bundle);
                setResult(2,intent);
                finish();
            }
        });

    }

}