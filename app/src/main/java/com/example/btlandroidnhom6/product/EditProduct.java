package com.example.btlandroidnhom6.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroidnhom6.R;

public class EditProduct extends AppCompatActivity {
    private EditText edt_name, edt_description,edt_price,edt_discount,edt_code;
    private ImageView imgProduct;
    public void anhxa(){
        edt_name = findViewById(R.id.edt_name);
        edt_code= findViewById(R.id.edt_code);
        edt_price= findViewById(R.id.edt_Price);
        edt_discount= findViewById(R.id.edt_discount);
        edt_description = findViewById(R.id.edt_description);
        imgProduct= findViewById(R.id.imgProduct);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        anhxa();

    }
}