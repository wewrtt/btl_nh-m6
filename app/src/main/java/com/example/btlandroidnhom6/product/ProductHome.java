package com.example.btlandroidnhom6.product;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.store.EditStore;
import com.example.btlandroidnhom6.store.StoreHome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductHome extends AppCompatActivity {
    private Store store;
    private  static  final  String TAG= ProductHome.class.getSimpleName();
    private Button btn_add;
    private GridView gridView;
    public static List<Product> listProduct;
    private ListProductAdapter adapter;
    private String store_id;
    private static final int REQUEST_CODE=800;
    public void anhxa(){
        gridView = findViewById(R.id.GridView_ListProduct);
        btn_add= findViewById(R.id.btn_add2);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        anhxa();
        listProduct = (List<Product>) getIntent().getExtras().get("listProduct");
        store_id= (String) getIntent().getExtras().get("store_id");
//        listProduct = new ArrayList<>();
//        listProduct.add(new Product("a","a","a",12));
//        listProduct.add(new Product("a","a","a",12));
//        listProduct.add(new Product("a","a","a",12));
        Log.e(TAG,listProduct.size()+" Hoang Duc Thang");
        adapter = new ListProductAdapter(ProductHome.this,listProduct,R.layout.product);
        gridView.setAdapter(adapter);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ProductHome.this, CreateProduct.class);
                i.putExtra("listProduct", (Serializable) listProduct);
                i.putExtra("store_id",store_id);
                activityResultLauncher.launch(i);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(ProductHome.this,ProductDetail.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alerb= new AlertDialog.Builder(ProductHome.this);
                alerb.setTitle("Chỉnh sửa thông tin sản phẩm");
                alerb.setPositiveButton("Chỉnh sửa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(ProductHome.this, EditProduct.class);
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
                                Toast.makeText(ProductHome.this, "Server Error!!", Toast.LENGTH_SHORT).show();
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
                        listProduct = (List<Product>) i.getExtras().get("listProduct");
                        adapter.notifyDataSetChanged();
                    }
                    else if(result.getResultCode()==702){
                        Intent i=result.getData();
                        Product a1= (Product) i.getExtras().get("infoProduct");
                        int position= (int) i.getExtras().get("position");
                        listProduct.set(position,a1);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(ProductHome.this, "Oke la la la", Toast.LENGTH_SHORT).show();
                    }

                }
            }
    );
}