package com.example.btlandroidnhom6.login_registor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.User;
import com.example.btlandroidnhom6.welcome.Welcom2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private TextView txt_re,txt_findPassword;
    private EditText edt_username,edt_password;
    private static  final  String TAG= LoginActivity.class.getSimpleName();
    public  void anhXa(){
        txt_findPassword=findViewById(R.id.findPassWord);
        edt_password= findViewById(R.id.password);
        edt_username = findViewById(R.id.username);
        btn_login=findViewById(R.id.btn_login);
        txt_re=findViewById(R.id.txt_re);
    }
    public void clickLogin(User user){
        APIService.apiService.login(user).enqueue(new Callback<Respone>() {
            @Override
            public void onResponse(Call<Respone> call, Response<Respone> response) {
                Respone respone = response.body();
                if(respone.getMessage().equals("login success")){

                    Intent i= new Intent(LoginActivity.this, Welcom2.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this,respone.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Respone> call, Throwable t) {
                Log.e(TAG,t.toString());
                Toast.makeText(LoginActivity.this,"server erro",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(edt_username.getText().toString(),edt_password.getText().toString());
                clickLogin(user);

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
        txt_findPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("login","here");
                Intent i = new Intent(LoginActivity.this, FindPassword.class);
                startActivity(i);
            }
        });
    }

}