package com.example.btlandroidnhom6.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.store.StoreHome;

import java.util.ArrayList;
import java.util.List;

public class ListProduct extends AppCompatActivity {
    private Store store;
    private  static  final  String TAG= ListProduct.class.getSimpleName();
    private Button btn_add;
    private GridView gridView;
    private List<Product> listProduct;
    private ListProductAdapter adapter;
    public void anhxa(){
        gridView = findViewById(R.id.GridView_ListProduct);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        anhxa();
//        listProduct = (List<Product>) getIntent().getExtras().get("listProduct");
        listProduct = new ArrayList<>();
        listProduct.add(new Product("a","a","a",12));
        listProduct.add(new Product("a","a","a",12));
        listProduct.add(new Product("a","a","a",12));
        Log.e(TAG,listProduct.size()+"");
        adapter = new ListProductAdapter(ListProduct.this,listProduct,R.layout.product);
        gridView.setAdapter(adapter);

    }
}