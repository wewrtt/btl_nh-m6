package com.example.btlandroidnhom6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.btlandroidnhom6.welcome.Test_Screem;
import com.example.btlandroidnhom6.welcome.Welcom2;

public class Welcome extends AppCompatActivity {
    Button btn,btn2;
    public void anhXa(){
        btn= findViewById(R.id.btn_next);
        btn2=findViewById(R.id.btn_test);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        anhXa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Welcome.this, Welcom2.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Welcome.this, Test_Screem.class);
                startActivity(i);
            }
        });

    }
}