package com.example.btlandroidnhom6.Home;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Category;
import com.example.btlandroidnhom6.model.ResponseStore;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.model.StoreAdapter;
import com.example.btlandroidnhom6.store.ListviewAdapter;
import com.example.btlandroidnhom6.model.User;
import com.example.btlandroidnhom6.profile.ProfileHome;
import com.example.btlandroidnhom6.store.StoreDetail;
import com.example.btlandroidnhom6.store.StoreHome;
import com.example.btlandroidnhom6.thongke.thongkeChainStore;
import com.example.btlandroidnhom6.thongke.thongkeStore;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG=MainActivity.class.getSimpleName();
    public  static  List<Store> storeList;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private  User mainUser;
    private TextView putin;
    private RecyclerView recyclerview;
    public static List<Category> categoryList;
    private StoreAdapter cuahangadapt;
    private ListView listView;
    private ListviewAdapter adapter;
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    private  TextView txt_store,txt_profile,txt_thongkestore,txt_thongkechainstore;

    private ImageView img_store,img_account,img_fragment;

    public void anhXa(){
        txt_store = findViewById(R.id.txt_store);
        txt_profile = findViewById(R.id.txt_profile);
        txt_thongkestore = findViewById(R.id.txt_thongke_store);
        txt_thongkechainstore = findViewById(R.id.txt_thongke_chainStore);

        toolbar = findViewById(R.id.viewtop);
        navigationView =findViewById(R.id.navigationView);
        drawerLayout= findViewById(R.id.DrawerLayout);
        putin = findViewById(R.id.putin);
        img_store=findViewById(R.id.img_store);
        img_account=findViewById(R.id.img_accont);
        User u = new User();
        mainUser= (LoginActivity.mainUser != null) ? LoginActivity.mainUser:u;
        putin.setText(mainUser.getFullname()+"");
        storeList = LoginActivity.storeList;
//        storeList.add(new Store("hanoi","a","a","a","a","a","a","a"));
//        storeList.add(new Store("hadong","a","a","a","a","a","a","a"));
//        storeList.add(new Store("hadong","a","a","a","a","a","a","a"));
//        storeList.add(new Store("hadong","a","a","a","a","a","a","a"));
    }
    private void  actionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        img_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StoreHome.class);
                startActivityForResult(i,REQUEST_CODE_EXAMPLE);
            }
        });
        img_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ProfileHome.class);
                startActivityForResult(i,2);
            }
        });

        txt_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StoreHome.class);
                startActivityForResult(i,2);
            }
        });
        txt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ProfileHome.class);
                startActivityForResult(i,2);
            }
        });
        txt_thongkestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, thongkeStore.class);
                startActivityForResult(i,1);
            }
        });
        txt_thongkechainstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, thongkeChainStore.class);
                startActivityForResult(i,2);
            }
        });
        actionToolBar();

        recyclerview = findViewById(R.id.recyclerView);
        categoryList= new ArrayList<>();

        categoryList.add(new Category(0,R.drawable.image));
        categoryList.add(new Category(1,R.drawable.image1));
        categoryList.add(new Category(2,R.drawable.image2));
        categoryList.add(new Category(3,R.drawable.image3));
        categoryList.add(new Category(4,R.drawable.image4));
        categoryList.add(new Category(5,R.drawable.image5));
        setcategory((ArrayList<Category>) categoryList);

        listView= findViewById(R.id.listview);

        adapter=new ListviewAdapter(MainActivity.this, storeList, R.layout.cuahang);
        //Log.e(TAG, storeList.get(1).getImageUrl());
        Log.e(TAG, storeList.size()+"");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(MainActivity.this, StoreDetail.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }
    private void setcategory(ArrayList<Category> datalist) {
        RecyclerView.LayoutManager layoutmanager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview.setLayoutManager(layoutmanager);
        cuahangadapt = new StoreAdapter(this,datalist);
        recyclerview.setAdapter(cuahangadapt);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_EXAMPLE){
            if(resultCode==MainActivity.RESULT_OK){
                adapter.notifyDataSetChanged();
//                Toast.makeText(this, "OKE nhé", Toast.LENGTH_SHORT).show();
//                 Intent intent = getIntent();
//                finish();
//                startActivity(intent);
            }

        }
        else{
        }

    }
}