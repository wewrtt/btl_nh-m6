package com.example.btlandroidnhom6.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Respone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProduct extends AppCompatActivity {
    private EditText edt_name, edt_description,edt_price,edt_discount,edt_code,edt_img;
    private Button btn_edit;
    public void anhxa(){
        edt_name = findViewById(R.id.edt_name);
        edt_code= findViewById(R.id.edt_code);
        edt_price= findViewById(R.id.edt_Price);
        edt_discount= findViewById(R.id.edt_discount);
        edt_description = findViewById(R.id.edt_description);
        edt_img=findViewById(R.id.edt_email2);
        btn_edit=findViewById(R.id.btn_create);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        anhxa();
        Intent i= this.getIntent();
        Product product= (Product) i.getExtras().get("infoProduct");
        int position= (int) i.getExtras().get("position");
        String name=product.getName();
        String code=product.getCodeProduct();
        String description= product.getDescription();
        String discount=product.getQuantity()+"";
        String price=product.getPrice()+"";
        edt_name.setText(name);
        edt_code.setText(code);
        edt_description.setText(description);
        edt_discount.setText(discount);
        edt_price.setText(price);
        edt_img.setText(product.getImages());
        edt_name.setEnabled(false);
        edt_code.setEnabled(false);
        edt_price.setEnabled(false);
        edt_description.setEnabled(false);
        edt_img.setEnabled(false);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String name, String codeProduct, String images, String description, int price, float discount, boolean isHot, List<String> listCategoryId, String storeId
                Product a= new Product(name,code,edt_img.getText().toString(),description,Integer.parseInt(price),Integer.parseInt(edt_discount.getText().toString()),false,product.getListCategoryId(),product.getUserId());

                APIService.apiService.putProduct(product.get_id(), a).enqueue(new Callback<Respone>() {
                    @Override
                    public void onResponse(Call<Respone> call, Response<Respone> response) {
                        Intent i=new Intent();
                        i.putExtra("quantity",a.getQuantity());
                        i.putExtra("index",position);
                        setResult(702,i);
                        finish();
                    }
                    @Override
                    public void onFailure(Call<Respone> call, Throwable t) {
                        Toast.makeText(EditProduct.this, "Server Error", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}