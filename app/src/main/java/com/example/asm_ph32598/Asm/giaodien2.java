package com.example.asm_ph32598.Asm;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.asm_ph32598.R;

import com.example.asm_ph32598.Asm.giaodien3;
import com.example.asm_ph32598.Asm.giaodien4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class giaodien2 extends ComponentActivity {
    EditText edt1, edt2;
    CheckBox chk1;
    Button btn1, btn2;
    Intent intent;
    String u = "", p = "";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_giaodien2);
            edt1 = findViewById(R.id.edt1);
            edt2 = findViewById(R.id.edt2);
            chk1 = findViewById(R.id.chk1);
            btn1 = findViewById(R.id.btn1);
            btn2 = findViewById(R.id.btn2);
            intent = getIntent();

            if(intent!=null){
                Bundle bundle = intent.getExtras();
                if(bundle!=null){
                    u = bundle.getString("u");
                    p = bundle.getString("p");
                }
            }
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(giaodien2.this,giaodien3.class);
                    startActivity(intent1);
                }
            });
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Boolean isU = u.equals(edt1.getText().toString());
                    Boolean isP = p.equals(edt2.getText().toString());
                    if(edt1.getText().toString().equals("")||edt2.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Username hoặc Password không được bỏ trống!",Toast.LENGTH_LONG).show();
                    }
                    if(isU&&isP&&u!=""&&p!=""){
                        Toast.makeText(getApplicationContext(),"Đăng Nhập Thành Công!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Đăng nhập Không Thành Công!",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"Username hoặc Password sai!",Toast.LENGTH_LONG).show();
                        return;
                    }
                    Intent intent2 = new Intent(giaodien2.this,giaodien4.class);
                    startActivity(intent2);
                }
            });
        }

    }


