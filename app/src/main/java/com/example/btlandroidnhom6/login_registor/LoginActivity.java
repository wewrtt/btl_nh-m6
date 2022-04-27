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
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.ResponseStore;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.model.User;
import com.example.btlandroidnhom6.welcome.Welcom2;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public  static  List<Store> storeList= new ArrayList<>();
    public static  User mainUser ;

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
                Log.e(TAG,respone.getStatusCode()+"");
                if(respone.getStatusCode()==201){
                    Intent i= new Intent(LoginActivity.this, Welcom2.class);
                    Object res= respone.getData();
                    Gson gson= new Gson();
                    JsonObject jsonObject = gson.toJsonTree(res).getAsJsonObject();
                    mainUser = gson.fromJson(jsonObject,User.class);
                    Log.e(TAG,mainUser.getUsername());
                    getListStore();
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this,"tài khoản đã tồn tại hoặc mật khẩu ko đúng",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Respone> call, Throwable t) {
                Log.e(TAG,t.toString());
                Toast.makeText(LoginActivity.this,"server erro",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void getListStore(){
        APIService.apiService.getListStore(mainUser.get_id()).enqueue(new Callback<ResponseStore>() {
            @Override
            public void onResponse(Call<ResponseStore> call, Response<ResponseStore> response) {
                ResponseStore res = response.body();
                if (res.getStatusCode() == 200) {
                    storeList = res.getData();

                }
            }
            @Override
            public void onFailure(Call<ResponseStore> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"tài khoản đã tồn tại hoặc mật khẩu ko đúng",Toast.LENGTH_LONG).show();
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