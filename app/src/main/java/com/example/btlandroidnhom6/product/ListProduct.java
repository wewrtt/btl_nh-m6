package com.example.btlandroidnhom6.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Store;

import java.util.ArrayList;
import java.util.List;

public class ListProduct extends AppCompatActivity {
    private Store store;
    private  static  final  String TAG= ListProduct.class.getSimpleName();
    private Button btn_add;
    private GridView gridView;
    private List<Product> listProduct=new ArrayList<>();
    private ListProductAdapter adapter;
    public void anhxa(){
        gridView = findViewById(R.id.GridView_ListProduct);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        anhxa();
//        Bundle bundle= getIntent().getExtras();
////        String storeid= bundle.getString("storeid");
////        Log.e(TAG,storeid);

        listProduct.add(new Product("áo len",R.drawable.image1+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image2+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image3+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image2+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image3+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image2+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image3+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image2+"","dày ",123));
        listProduct.add(new Product("áo len",R.drawable.image3+"","dày ",123));
        adapter = new ListProductAdapter(ListProduct.this,listProduct,R.layout.product);
        gridView.setAdapter(adapter);

    }
}