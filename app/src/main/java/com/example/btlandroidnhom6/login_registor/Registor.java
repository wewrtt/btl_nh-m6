package com.example.btlandroidnhom6.login_registor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.User;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registor extends AppCompatActivity  {
    private EditText txt_fullname,txt_userName,txt_passWord,txt_email;
    private TextView txt_back;
    private Button btn_register;
    private static  final  String TAG= Registor.class.getSimpleName();
    public User user;
    public  void anhXa(){
        btn_register =findViewById(R.id.btn_registor);
        txt_back=findViewById(R.id.txt_back);
        txt_fullname=findViewById(R.id.fullName);
        txt_userName=findViewById(R.id.username);
        txt_passWord=findViewById(R.id.password);
        txt_email= findViewById(R.id.email);


        txt_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
                if(!Pattern.matches(pattern,txt_email.getText().toString())){
                    txt_email.setError("email is not format");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
                if(!Pattern.matches(pattern,txt_email.getText().toString())){
                    txt_email.setError("email is not format");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
                if(!Pattern.matches(pattern,txt_email.getText().toString())){
                    txt_email.setError("email is not format");
                }
            }
        });

        txt_passWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String pattern="[a-zA-Z0-9]{1,}";
                if(!Pattern.matches(pattern,txt_passWord.getText().toString())){
                    txt_passWord.setError("password is at least 1 character");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pattern="[a-zA-Z0-9]{1,}";
                if(!Pattern.matches(pattern,txt_passWord.getText().toString())){
                    txt_passWord.setError("password is at least 1 character");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String pattern="[a-zA-Z0-9]{1,}";
                if(!Pattern.matches(pattern,txt_passWord.getText().toString())){
                    txt_passWord.setError("password is at least 1 character");
                }
            }
        });


        txt_userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String pattern="[a-zA-Z]{4,}";
                if(!Pattern.matches(pattern,txt_userName.getText().toString())){
                    txt_userName.setError("userName include at least 4 charracter");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pattern="[a-zA-Z]{4,}";
                if(!Pattern.matches(pattern,txt_userName.getText().toString())){
                    txt_userName.setError("userName include at least 4 charracter");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String pattern="[a-zA-Z]{4,}";
                if(!Pattern.matches(pattern,txt_userName.getText().toString())){
                    txt_userName.setError("userName include at least 4 charracter");
                }
            }
        });

        txt_fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String pattern="[a-zA-Z]{4,}";
                if(!Pattern.matches(pattern,txt_fullname.getText().toString())){
                    txt_fullname.setError("userName include at least 4 charracter");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pattern="[a-zA-Z]{4,}";
                if(!Pattern.matches(pattern,txt_fullname.getText().toString())){
                    txt_fullname.setError("fullName inclue 4 charracter");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String pattern="[a-zA-Z]{4,}";
                if(!Pattern.matches(pattern,txt_fullname.getText().toString())){
                    txt_fullname.setError("fullName inclue 4 charracter");
                }
            }
        });
    }
    public void validate(){
        txt_fullname.addTextChangedListener((TextWatcher) Registor.this);
    }

    public void clickLogin(User user){

        APIService.apiService.registor(user).enqueue(new Callback<Respone>() {
            @Override
            public void onResponse(Call<Respone> call, Response<Respone> response) {
                Respone res= response.body();
                Log.e(TAG,res.getStatusCode()+"");
                if(res.getStatusCode()==201){
                    Registor.this.finish();
                }
                else {
                    Toast.makeText(Registor.this,"tài khoản đã tồn tại",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respone> call, Throwable t) {
                Log.e(TAG,t.toString());
                Toast.makeText(Registor.this,"server erro",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);
        anhXa();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=txt_userName.getText().toString();
                String passWord=txt_passWord.getText().toString();
                String fullName=txt_fullname.getText().toString();
                String email=txt_email.getText().toString();
//                user= new User(fullName,userName,passWord,email);
//                clickLogin(user);

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