package com.example.btlandroidnhom6.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.model.Category;
import com.example.btlandroidnhom6.model.Cuahang;
import com.example.btlandroidnhom6.model.CuahangAdapter;
import com.example.btlandroidnhom6.model.ListviewAdapter;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.User;
import com.example.btlandroidnhom6.profile.ProfileHome;
import com.example.btlandroidnhom6.store.StoreHome;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG=MainActivity.class.getSimpleName();

    private TextView putin;
    RecyclerView recyclerview;
    List<Category> categoryList;
    CuahangAdapter cuahangadapt;
    private ListView listView;
    List<Cuahang> cuahangList;
    private ListviewAdapter adapter;
    private  Bundle extrax;
    private ImageView img_store,img_account;
    public void anhXa(){
        putin = findViewById(R.id.putin);
        img_store=findViewById(R.id.img_store);
        img_account=findViewById(R.id.img_accont);
        extrax= getIntent().getExtras();

        //putin.setText(extrax.get("fullName")+"");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        img_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StoreHome.class);
                startActivity(i);
            }
        });
        img_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ProfileHome.class);
                startActivity(i);
            }
        });
        recyclerview = findViewById(R.id.recyclerView);
        categoryList= new ArrayList<>();

        categoryList.add(new Category(0,R.drawable.image));
        categoryList.add(new Category(1,R.drawable.image1));
        categoryList.add(new Category(2,R.drawable.image2));
        categoryList.add(new Category(3,R.drawable.image3));
        categoryList.add(new Category(4,R.drawable.image4));
        categoryList.add(new Category(5,R.drawable.image5));
        setcategory((ArrayList<Category>) categoryList);


        cuahangList = new ArrayList<Cuahang>();
        cuahangList.add(new Cuahang("Hà Nội","giày","Cửa hàng của long",1000,R.drawable.image5));
        cuahangList.add(new Cuahang("hà Tây","trang sức","Cửa hàng của thắng",9999,R.drawable.image1));
        cuahangList.add(new Cuahang("yên nghĩa","son môi","Cửa hàng của Ngọc",10000,R.drawable.image2));
        cuahangList.add(new Cuahang("đồng nai","quần áo","Cửa hàng của Thành",9999,R.drawable.image3));

        listView= findViewById(R.id.listview);
        adapter=new ListviewAdapter(MainActivity.this,cuahangList, R.layout.cuahang);
        listView.setAdapter(adapter);
    }

    private void setcategory(ArrayList<Category> datalist) {
        RecyclerView.LayoutManager layoutmanager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview.setLayoutManager(layoutmanager);
        cuahangadapt = new CuahangAdapter(this,datalist);
        recyclerview.setAdapter(cuahangadapt);
    }
}