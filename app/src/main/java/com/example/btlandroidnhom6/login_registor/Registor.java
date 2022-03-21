package com.example.btlandroidnhom6.login_registor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;

public class Registor extends AppCompatActivity {
    private TextView txt_back;
    private Button btn_login1;
    public  void anhXa(){
        btn_login1=findViewById(R.id.btn_back);
        txt_back=findViewById(R.id.txt_back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);
        anhXa();
        btn_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registor.this.finish();
            }
        });
        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registor.this.finish();
            }
        });
    }
}