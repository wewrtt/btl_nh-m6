package com.example.btlandroidnhom6.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.store.StoreHome;

public class ProfileHome extends AppCompatActivity {
    private ImageView img_store,img_home;
    public void anhXa(){
        img_store=findViewById(R.id.img_store);
        img_home=findViewById(R.id.img_home);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_home);
        anhXa();
        img_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ProfileHome.this, StoreHome.class);
                startActivity(i);
            }
        });
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ProfileHome.this, MainActivity.class);
                startActivity(i);


            }
        });
    }
}