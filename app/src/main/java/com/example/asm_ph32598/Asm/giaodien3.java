package com.example.asm_ph32598.Asm;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm_ph32598.R;

public class giaodien3 extends ComponentActivity {
    EditText edt1,edt2,edt3;
    Button btn1,btn2;
    Intent intent2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien3);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2 = new Intent(giaodien3.this,giaodien2.class);
                Bundle bundle = new Bundle();
                if(edt1.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Username không được bỏ trống!",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    bundle.putString("u",edt1.getText().toString());
                }
                if(edt2.getText().toString().equals("")&&edt3.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Password không được bỏ trống!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(edt2.getText().toString().equals(edt3.getText().toString())){
                    bundle.putString("p",edt2.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(),"Password không giống nhau!",Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Đăng Ký Thành Công",Toast.LENGTH_LONG).show();
                intent2.putExtras(bundle);
                startActivity(intent2);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(giaodien3.this,giaodien2.class);
                startActivity(intent3);
            }
        });
    }
}