package com.example.btlandroidnhom6.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.Store;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditStore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_store);
        Intent i= this.getIntent();
        Store a= (Store) i.getSerializableExtra("infoStore");
        EditText edt_name= findViewById(R.id.edt_name);
        EditText edt_add= findViewById(R.id.edt_add);
        EditText edt_phone= findViewById(R.id.edt_phone);
        EditText edt_description= findViewById(R.id.edt_description);
        EditText edt_email= findViewById(R.id.edt_email);
        EditText edt_img= findViewById(R.id.edt_email2);
        Button btn_create= findViewById(R.id.btn_create);
        edt_name.setText(a.getName());
        edt_add.setText(a.getAddress());
        edt_email.setText(a.getEmail());
        edt_phone.setText(a.getPhoneNumber());
        edt_description.setText(a.getDescription());
        edt_img.setText(a.getImageUrl());
        //Tìm cửa hàng
        int pos=i.getIntExtra("index",0);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//String address, String description, String email, String isRoot, String name, String phoneNumber, String userId, String imageUrl
            Store a1= new Store(edt_add.getText().toString(),edt_description.getText().toString(),edt_email.getText().toString(),false,edt_name.getText().toString(),edt_phone.getText().toString(),a.getUserId(),edt_img.getText().toString());
                APIService.apiService.putStore(a.get_id(),a1).enqueue(new Callback<Respone>() {
                    @Override
                    public void onResponse(Call<Respone> call, Response<Respone> response) {
                        LoginActivity.storeList.set(pos,a1);
                        Intent i= new Intent();
                        setResult(EditStore.RESULT_OK,i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Respone> call, Throwable t) {
                        Toast.makeText(EditStore.this, "Server Error", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}