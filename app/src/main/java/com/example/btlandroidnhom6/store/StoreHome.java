package com.example.btlandroidnhom6.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.profile.ProfileHome;

public class StoreHome extends AppCompatActivity {
    private Button btn;
    private ImageView img_profile,img_home;
    public void anhXa(){
        img_profile=findViewById(R.id.img_profile);
        img_home=findViewById(R.id.img_home);
        btn=findViewById(R.id.btn_add);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_store);
        anhXa();
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
                startActivity(i);
            }
        });
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StoreHome.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}