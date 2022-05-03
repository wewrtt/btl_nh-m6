package com.example.btlandroidnhom6.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.Stock;
import com.example.btlandroidnhom6.product.ManageProduct;
import com.example.btlandroidnhom6.product.ProductHome;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductForStore extends AppCompatActivity  {
    private String store_id;
    public String TAG = this.getClass().getSimpleName();
    private EditText edt_name, edt_description,edt_price,edt_discount,edt_code,edt_img;
    private Button btn_edit;
    private Product glo= new Product();
    private Spinner spinner;
    private String[] list;
    private List<Product> productList;
    private ArrayAdapter<String> adapter;
    public void anhxa() {
        edt_name = findViewById(R.id.edt_name);
        edt_code= findViewById(R.id.edt_code);
        edt_price= findViewById(R.id.edt_Price);
        edt_discount= findViewById(R.id.edt_discount);
        edt_description = findViewById(R.id.edt_description);
        edt_img=findViewById(R.id.edt_email2);
        btn_edit=findViewById(R.id.btn_create);
        store_id = (String) getIntent().getExtras().get("store_id");
        productList= (List<Product>) getIntent().getExtras().get("listProduct");
        spinner = findViewById(R.id.spinner);
        edt_name.setEnabled(false);
        edt_code.setEnabled(false);
        edt_price.setEnabled(false);
        edt_description.setEnabled(false);
        edt_img.setEnabled(false);

//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_for_store);
        anhxa();
        list= new String[productList.size()+1];
        list[0]="";
        for(int i=0;i<productList.size();i++){
            list[i+1]= productList.get(i).getName();
        }
        adapter = new ArrayAdapter<String>(AddProductForStore.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
                ,list);
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btn_edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int soluong= Integer.parseInt(edt_discount.getText().toString());
                Stock stock= new Stock(store_id,glo.get_id(),Integer.parseInt(edt_discount.getText().toString()));
                APIService.apiService.postProductForStore(LoginActivity.mainUser.get_id(),stock).enqueue(new Callback<Respone>() {
                    @Override
                    public void onResponse(Call<Respone> call, Response<Respone> response) {
                        Intent i= new Intent();
                        glo.setQuantity(soluong);
                        i.putExtra("product",glo);
                        setResult(706,i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Respone> call, Throwable t) {

                    }
                });

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                    Product p= productList.get(position-1);
                    edt_name.setText(p.getName()+"");
                    edt_code.setText(p.getCodeProduct()+"");
                    edt_price.setText(p.getPrice()+"");
                    edt_discount.setText(p.getQuantity()+"");
                    edt_description.setText(p.getDescription()+"");
                    edt_img.setText(p.getImages()+"");
                    glo=p;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
/*
Stock stock= new Stock(store_id,p.get_id(),Integer.parseInt(edt_discount.getText().toString()));
                    APIService.apiService.postProductForStore(LoginActivity.mainUser.get_id(),stock).enqueue(new Callback<Respone>() {
                        @Override
                        public void onResponse(Call<Respone> call, Response<Respone> response) {
                            Intent i= new Intent();
                            i.putExtra("product",p);
                            setResult(706,i);
                            finish();

                        }

                        @Override
                        public void onFailure(Call<Respone> call, Throwable t) {

                        }
                    });

 */