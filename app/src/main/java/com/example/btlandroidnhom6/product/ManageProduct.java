package com.example.btlandroidnhom6.product;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Respone;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageProduct extends AppCompatActivity {
    private  static  final  String TAG= ManageProduct.class.getSimpleName();
    private GridView gridView;
    private  Button btn_add;
    public static List<Product> listProduct;
    private ListProductAdapter adapter;
    public void anhxa(){
        gridView = findViewById(R.id.GridView_ListProduct);
        btn_add = findViewById(R.id.btn_addMana);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        anhxa();
        listProduct= MainActivity.listProduct;
        adapter = new ListProductAdapter(ManageProduct.this,listProduct,R.layout.product);
        gridView.setAdapter(adapter);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageProduct.this, CreateProduct.class);
                activityResultLauncher.launch(i);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alerb= new AlertDialog.Builder(ManageProduct.this);
                alerb.setTitle("Chỉnh sửa thông tin sản phẩm");
                alerb.setPositiveButton("Chỉnh sửa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(ManageProduct.this, EditProductOwner.class);
                        i.putExtra("infoProduct",listProduct.get(position));
                        i.putExtra("position",position);
                        activityResultLauncher.launch(i);
                    }
                });
                alerb.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        APIService.apiService.deleteProduct(listProduct.get(position).get_id()).enqueue(new Callback<Respone>() {
                            @Override
                            public void onResponse(Call<Respone> call, Response<Respone> response) {
                            }

                            @Override
                            public void onFailure(Call<Respone> call, Throwable t) {
                                Toast.makeText(ManageProduct.this, "Server Error!!", Toast.LENGTH_SHORT).show();
                            }
                        });

                        listProduct.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                AlertDialog alertDialog= alerb.create();
                alertDialog.show();
                return true;
            }

        });
    }
    private ActivityResultLauncher<Intent> activityResultLauncher =  registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==701){
                        Intent i = result.getData();
                        Product product = (Product) i.getExtras().get("product");
                        listProduct.add(product);
                        adapter.notifyDataSetChanged();
                    }
                    else if(result.getResultCode()==702){
                        Intent i=result.getData();
                        Product a= (Product) i.getExtras().get("product");
                        int position= (int) i.getExtras().get("position");
                        listProduct.set(position,a);
                        adapter.notifyDataSetChanged();
                    }

                }
            }
    );




}