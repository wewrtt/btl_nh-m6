package com.example.btlandroidnhom6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.ResponeUser;
import com.example.btlandroidnhom6.model.User;
import com.example.btlandroidnhom6.product.CreateProduct;
import com.example.btlandroidnhom6.product.ListProduct;
import com.example.btlandroidnhom6.store.CreateStore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcome extends AppCompatActivity {
    Button btn,btn2,btn_api;
    public  final  static  String TAG = Welcome.class.getSimpleName();
    public void anhXa(){
        btn= findViewById(R.id.btn_next);
        btn2=findViewById(R.id.btn_test);
        btn_api = findViewById(R.id.btn_testApi);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        anhXa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Welcome.this, LoginActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("registor","here");
                Intent i= new Intent(Welcome.this, CreateProduct.class);
                startActivity(i);
            }
        });
        btn_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Welcome.this, MainActivity.class);
                startActivity(i);

            }
        });

    }

}