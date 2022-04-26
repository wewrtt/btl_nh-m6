package com.example.btlandroidnhom6.login_registor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindPassword extends AppCompatActivity {
    private EditText txt_userName,txt_email;
    private Button btn_findPassWord;
    private ImageView img_back;
    public void anhXa(){
        img_back=findViewById(R.id.img_back);
        txt_userName = findViewById(R.id.username);
        txt_email=findViewById(R.id.email);
        btn_findPassWord=findViewById(R.id.btn_find);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        anhXa();
        btn_findPassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user= new User();
                user.setUsername(txt_userName.getText().toString());
                user.setEmail(txt_email.getText().toString());
                click_button(user);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindPassword.this.finish();
            }
        });
    }
    public void click_button(User user){
       APIService.apiService.findPassword(user).enqueue(new Callback<Respone>() {
           @Override
           public void onResponse(Call<Respone> call, Response<Respone> response) {
               Respone res= response.body();
               if(res.getStatusCode() == 200){
                   Toast.makeText(FindPassword.this,"check your eamil for get password",Toast.LENGTH_LONG).show();
               }
               else {
                   Toast.makeText(FindPassword.this,"userName or email incorrect",Toast.LENGTH_LONG).show();
               }
           }

           @Override
           public void onFailure(Call<Respone> call, Throwable t) {

           }
       });
    };
}