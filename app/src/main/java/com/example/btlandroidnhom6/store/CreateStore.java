package com.example.btlandroidnhom6.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.Store;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        EditText edt_name= findViewById(R.id.edt_name1);
        EditText edt_add= findViewById(R.id.edt_add1);
        EditText edt_phone= findViewById(R.id.edt_Phone1);
        EditText edt_description= findViewById(R.id.edt_description1);
        EditText edt_email= findViewById(R.id.edt_email1);
        EditText edt_img= findViewById(R.id.edt_email21);
        Button btn_create= findViewById(R.id.btn_create1);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Store a1= new Store(edt_add.getText().toString(),edt_description.getText().toString(),edt_email.getText().toString(),false,edt_name.getText().toString(),edt_phone.getText().toString(), LoginActivity.mainUser.get_id(),edt_img.getText().toString());
                APIService.apiService.postStore(a1).enqueue(new Callback<Respone>() {
                    @Override
                    public void onResponse(Call<Respone> call, Response<Respone> response) {
                        LoginActivity.storeList.add(a1);
                        Intent i= new Intent();
                        setResult(700,i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Respone> call, Throwable t) {
                        Toast.makeText(CreateStore.this, "Server Error!!!", Toast.LENGTH_SHORT).show();
                    }
                });


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