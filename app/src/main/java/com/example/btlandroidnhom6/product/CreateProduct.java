package com.example.btlandroidnhom6.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Category;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Respone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateProduct extends AppCompatActivity {
    private EditText edt_name,edt_code,edt_description,edt_Price,edt_discount,edt_img;
    private String store_id;
    private Button btn_create;
    private  static  final  String TAG= CreateProduct.class.getSimpleName();
    private List<Product> listProduct;
    public  void anhxa(){
        edt_name = findViewById(R.id.edt_name2);
        edt_code = findViewById(R.id.edt_code2);
        edt_description = findViewById(R.id.edt_description2);
        edt_Price = findViewById(R.id.edt_Price2);
        edt_discount = findViewById(R.id.edt_discount2);
        edt_img = findViewById(R.id.edt_img2);
        btn_create= findViewById(R.id.btn_create2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        anhxa();
        store_id = (String) this.getIntent().getExtras().get("store_id");
        listProduct = (List<Product>) this.getIntent().getExtras().get("listProduct");
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name.getText().toString();
                String codeProduct = edt_code.getText().toString();
                String img = edt_img.getText().toString();
                String description = edt_description.getText().toString();
                int price = Integer.parseInt(edt_Price.getText().toString());
                float discount = Float.parseFloat(edt_discount.getText().toString());
                List<String> cat= new ArrayList<>();
                cat.add("Trang sức");
                cat.add("Thời trang nam");
                Product product = new Product(name,codeProduct,img,description,price,discount,true,cat,store_id);
                APIService.apiService.postProduct(product).enqueue(new Callback<Respone>() {
                    @Override
                    public void onResponse(Call<Respone> call, Response<Respone> response) {
                        Intent i= new Intent();
                        listProduct.add(product);
                        i.putExtra("listProduct", (Serializable) listProduct);
                        setResult(701,i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Respone> call, Throwable t) {
                        Toast.makeText(CreateProduct.this, "Server Error!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}