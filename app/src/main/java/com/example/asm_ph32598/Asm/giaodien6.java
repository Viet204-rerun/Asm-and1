package com.example.asm_ph32598.Asm;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.example.asm_ph32598.R;

import java.util.ArrayList;

public class giaodien6 extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    ListView lv;
    Toolbar toolbar;
    appdater appdater;
    SearchView searchView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien6);
        btn1 =findViewById(R.id.btnthemnhanvien);
        btn2 = findViewById(R.id.btnchinhsua);
        btn4 = findViewById(R.id.btnxoa);
        lv = findViewById(R.id.lv1);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ArrayList<nhanvien> list = new ArrayList<>();
        list.add(new nhanvien("Mã NV: NV001","Họ tên: Nguyễn Văn B","Phòng Ban: Hành Chính"));
        list.add(new nhanvien("Mã NV: NV002","Họ tên: Nguyễn Văn C","Phòng Ban: Nhân Sự"));
        list.add(new nhanvien("Mã NV: NV003","Họ tên: Nguyễn Văn D","Phòng Ban: Nhân Sự"));
        list.add(new nhanvien("Mã NV: NV004","Họ tên: Nguyễn Văn E","Phòng Ban: Đào Tạo"));
        appdater = new appdater(this,list);
        lv.setAdapter(appdater);

        ActivityResultLauncher<Intent> getData = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==2){
                            Intent intent = result.getData();
                            Bundle bundle = intent.getExtras();
                            String manv = bundle.getString("ma_nv");
                            String tennv = bundle.getString("ten_nv");
                            String phongban = bundle.getString("phong_ban");
                            list.add(new nhanvien("Mã NV: "+manv,"Họ Tên: "+tennv,"Phòng Ban: "+phongban));
                            appdater.notifyDataSetChanged();
                        }
                    }
                }
        );
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giaodien6.this, giaodien7.class);
                getData.launch(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem myActionmenu = menu.findItem(R.id.search);
        searchView=(SearchView) myActionmenu.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                appdater.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                appdater.getFilter().filter(newText);
                return false;
            }
        });
        return true;

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}