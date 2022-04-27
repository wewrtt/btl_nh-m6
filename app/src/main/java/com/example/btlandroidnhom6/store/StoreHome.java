package com.example.btlandroidnhom6.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.product.ListProduct;
import com.example.btlandroidnhom6.profile.ProfileHome;

import java.util.List;

public class StoreHome extends AppCompatActivity {
    private Button btn;
    private ImageView img_profile,img_home;
    private List<Store> storeList;
    private ListView listView;
    private ListviewAdapter adapter;
    private static final  String TAG=StoreHome.class.getSimpleName();
    public void anhXa(){
        img_profile=findViewById(R.id.img_profile);
        img_home=findViewById(R.id.img_home);
        btn=findViewById(R.id.btn_add);
        storeList= LoginActivity.storeList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_store);
        anhXa();
        listView= findViewById(R.id.StoreHome_ListView);
        adapter=new ListviewAdapter(StoreHome.this, storeList, R.layout.cuahang);
        listView.setAdapter(adapter);
        //Set on click listener for listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(StoreHome.this, ListProduct.class);
                i.putExtra("storeid",storeList.get(position).get_id());
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StoreHome.this,CreateStore.class);
                startActivity(i);
            }
        });
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StoreHome.this, ProfileHome.class);
                startActivityForResult(i,3);
            }
        });
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent();
                setResult(MainActivity.RESULT_OK,i);
                finish();
            }
        });
    }
}