package com.example.asm_ph32598.Asm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.example.asm_ph32598.R;

import java.util.ArrayList;

public class appdater extends BaseAdapter
        implements Filterable {

    private Context context;
    private ArrayList<nhanvien> list,listOld;

    public appdater(Context context, ArrayList<nhanvien> list) {
        this.context = context;
        this.listOld=list;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item1,parent,false);
        TextView manv = convertView.findViewById(R.id.manv);
        TextView hoTen = convertView.findViewById(R.id.hoten);
        TextView phongBan = convertView.findViewById(R.id.phongban);
        Button btnxoa =convertView.findViewById(R.id.btnxoa);
        Button btncapnhat = convertView.findViewById(R.id.btnchinhsua);
        manv.setText(list.get(position).getManv());
        hoTen.setText(list.get(position).getHoTen());
        phongBan.setText(list.get(position).getPhongBan());
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(context);
                LayoutInflater inflater1 = ((Activity)context).getLayoutInflater();
                View view = inflater1.inflate(R.layout.diglog,null);
                builder.setView(view);
                final EditText editText = view.findViewById(R.id.manv1);
                final EditText editText1 = view.findViewById(R.id.tennv1);
                final EditText editText2 = view.findViewById(R.id.phongban1);
                builder.setTitle("Cập Nhật Nhân Viên");

                builder.setPositiveButton("Cập Nhật", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String manv =   editText.getText().toString();
                        String tennv =   editText1.getText().toString();
                        String phongban =   editText2.getText().toString();
                        list.get(position).setManv("Mã NV: "+manv);
                        list.get(position).setHoTen("Họ Tên: "+tennv);
                        list.get(position).setPhongBan("Phòng Ban: "+phongban);

                    }
                });

                AlertDialog alertDialog=builder.create();
                alertDialog.show();
                Drawable backgroundDrawable = ContextCompat.getDrawable(context, R.drawable.diglog);
                alertDialog.getWindow().setBackgroundDrawable(backgroundDrawable);
            }
        });
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s =constraint.toString();
                if(s.isEmpty()){
                    list=listOld;
                }else{
                    ArrayList<nhanvien> listS = new ArrayList<>();
                    for(nhanvien nv : listOld){
                        if(nv.getHoTen().toLowerCase().contains(s.toLowerCase())){
                            listS.add(nv);
                        }
                    }
                    list=listS;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list=(ArrayList<nhanvien>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
