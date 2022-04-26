package com.example.btlandroidnhom6.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.User;
import com.example.btlandroidnhom6.store.StoreHome;

public class ProfileHome extends AppCompatActivity {
    public static  final  String TAG= ProfileHome.class.getSimpleName();
    private ImageView img_store,img_home;
    private TextView txt_userName,txt_fullName,txt_email;
    private User mainUser;
    public void anhXa(){
        img_store=findViewById(R.id.img_store);
        img_home=findViewById(R.id.img_home);
        txt_userName=findViewById(R.id.username);
        txt_fullName=findViewById(R.id.fullName);
        txt_email=findViewById(R.id.email);
        User u = new User();
        mainUser = (LoginActivity.mainUser != null) ? LoginActivity.mainUser:u;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_home);
        anhXa();
        txt_userName.setText(mainUser.getUsername());
        txt_email.setText(mainUser.getEmail());
        txt_fullName.setText(mainUser.getFullname());
        img_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent();
                setResult(StoreHome.RESULT_OK,i);
                finish();
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