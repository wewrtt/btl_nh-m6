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

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private TextView txt_re;
    public  void anhXa(){
        btn_login=findViewById(R.id.btn_login);
        txt_re=findViewById(R.id.txt_re);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        txt_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Log.e("login","here");
                Intent i = new Intent(LoginActivity.this, Registor.class);
                startActivity(i);
            }
        });
    }

}