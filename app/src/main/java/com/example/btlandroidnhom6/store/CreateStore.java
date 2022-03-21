package com.example.btlandroidnhom6.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.btlandroidnhom6.R;

public class CreateStore extends AppCompatActivity {
    private Button btn_create;
    private ImageView arrow;
    public  void anhXa(){
        arrow =findViewById(R.id.img_arrow);
        btn_create=findViewById(R.id.btn_create);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_store);
        anhXa();
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gửi 1 cái j đó sang bên home để call api
                Intent i= new Intent(CreateStore.this, StoreHome.class);
                startActivity(i);
            }
        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateStore.this.finish();
            }
        });
    }
}