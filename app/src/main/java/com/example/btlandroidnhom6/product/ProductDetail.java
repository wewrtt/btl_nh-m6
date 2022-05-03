package com.example.btlandroidnhom6.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.model.Product;
import com.squareup.picasso.Picasso;

public class ProductDetail extends AppCompatActivity {
    private TextView txt_name,txt_descripton,txt_price,txt_discount,txt_code;
    private ImageView imgProduct;
    public void anhxa(){
        txt_name= findViewById(R.id.txt_name);
        txt_code= findViewById(R.id.txt_code);
        txt_price= findViewById(R.id.txt_price);
        txt_discount= findViewById(R.id.txt_discount);
        txt_descripton= findViewById(R.id.txt_description);
        imgProduct= findViewById(R.id.imgProduct);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        anhxa();
        Product product= ProductHome.listProduct.get((int) this.getIntent().getExtras().get("position"));
        txt_name.setText(product.getName());
        txt_code.setText(product.getCodeProduct());
        txt_price.setText(product.getPrice()+"");
        txt_discount.setText(product.getQuantity()+"");
        txt_descripton.setText(product.getDescription());
        Picasso.get().load(product.getImages()).into(imgProduct);
    }
}