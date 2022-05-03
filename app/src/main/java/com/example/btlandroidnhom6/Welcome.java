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
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.ResponeProduct;
import com.example.btlandroidnhom6.product.CreateProduct;
import com.example.btlandroidnhom6.product.ManageProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcome extends AppCompatActivity {
    Button btn,btn2,btn_api;
    public static List<Product> listProduct= new ArrayList<>();
    public  final  static  String TAG = Welcome.class.getSimpleName();
    public void anhXa(){
        btn= findViewById(R.id.btn_next);
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
    }
    public  List<Product> getAllProduct() {
        APIService.apiService.getAllProduct(LoginActivity.mainUser.get_id()).enqueue(new Callback<ResponeProduct>() {
            @Override
            public void onResponse(Call<ResponeProduct> call, Response<ResponeProduct> response) {
                ResponeProduct res = response.body();
                if (res.getStatusCode() == 200) {
                    listProduct = res.getData();
                    Intent i= new Intent(Welcome.this, ManageProduct.class);
                    startActivity(i);
                }
            }
            @Override
            public void onFailure(Call<ResponeProduct> call, Throwable t) {

            }
        });
        return listProduct;
    }

}