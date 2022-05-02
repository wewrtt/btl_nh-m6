package com.example.btlandroidnhom6.store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.product.ProductHome;
import com.squareup.picasso.Picasso;

public class StoreDetail extends AppCompatActivity {
    private TextView txt_name,txt_add,txt_phone,txt_descripton,txt_email;
    private ImageView imgStore;
    public void anhxa(){
        txt_name= findViewById(R.id.txt_name);
        txt_add= findViewById(R.id.txt_add);
        txt_phone= findViewById(R.id.txt_Phone);
        txt_descripton= findViewById(R.id.txt_description1);
        txt_email= findViewById(R.id.txt_email);
        imgStore= findViewById(R.id.imgStore);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);
        anhxa();
        Store store= StoreHome.storeList.get((Integer) this.getIntent().getExtras().get("position"));
        txt_name.setText(store.getName());
        txt_add.setText(store.getAddress());
        txt_phone.setText(store.getPhoneNumber()+"");
        txt_email.setText(store.getEmail()+"");
        txt_descripton.setText(store.getDescription());
        Picasso.get().load(store.getImageUrl()).into(imgStore);
    }
}