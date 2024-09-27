package com.example.asm_ph32598.Asm;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asm_ph32598.R;

public class giaodien1 extends ComponentActivity {
    ImageView imgfpoly,imglogo,imgtext;
    TextView tvtext1,tvtext2,tvtext3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien1);
        imgfpoly = findViewById(R.id.fpoly);
        imglogo = findViewById(R.id.logoapp);
        imgtext = findViewById(R.id.logotext);
        tvtext1 = findViewById(R.id.text1);
        tvtext2 = findViewById(R.id.text2);
        tvtext3 = findViewById(R.id.text3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation);
        imgfpoly.startAnimation(animation);
        imglogo.startAnimation(animation);
        imgtext.startAnimation(animation);
        tvtext1.startAnimation(animation);
        tvtext2.startAnimation(animation);
        tvtext3.startAnimation(animation);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(giaodien1.this,giaodien2.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

}