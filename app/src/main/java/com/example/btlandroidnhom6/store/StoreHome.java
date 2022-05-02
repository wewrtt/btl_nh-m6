package com.example.btlandroidnhom6.store;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.ResponeProduct;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.product.ProductHome;
import com.example.btlandroidnhom6.profile.ProfileHome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreHome extends AppCompatActivity {
    private Button btn;
    private ImageView img_profile,img_home;
   public static List<Store> storeList;
    private ListView listView;
    private ListviewAdapter adapter;
    private static final  String TAG=StoreHome.class.getSimpleName();
    public static  List<Product> productList= new ArrayList<>();
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    public void anhXa(){
        img_profile=findViewById(R.id.img_profile);
        img_home=findViewById(R.id.img_home);
        btn=findViewById(R.id.btn_add);
        storeList= LoginActivity.storeList;

//        storeList = new ArrayList<>();
//        storeList.add(new Store("hanoi","a","a","a","a","a","a","a"));
//        storeList.add(new Store("dong da","a","a","a","a","a","a","a"));
//        storeList.add(new Store("dong hoi","a","a","a","a","a","a","a"));
//        storeList.add(new Store("hadong","a","a","a","a","a","a","a"));
    }


    public List<Product>  getListProduct(String _id){
        APIService.apiService.getListProduct(_id).enqueue(new Callback<ResponeProduct>() {
            @Override
            public void onResponse(Call<ResponeProduct> call, Response<ResponeProduct> response) {
                ResponeProduct res= response.body();
                if(res.getStatusCode()==200){
                productList = res.getData();
                    Intent i= new Intent(StoreHome.this, ProductHome.class);
                    i.putExtra("listProduct", (Serializable) productList);
                    i.putExtra("store_id",_id);

                    startActivity(i);
                }
                else {
                    Toast.makeText(StoreHome.this,"server erro",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponeProduct> call, Throwable t) {

            }
        });
        return productList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_store);
        anhXa();
        listView= findViewById(R.id.StoreHome_ListView);
        adapter=new ListviewAdapter(StoreHome.this, storeList, R.layout.cuahang);
        listView.setAdapter(adapter);
        //Set on click listener for listview

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alerb= new AlertDialog.Builder(StoreHome.this);
                alerb.setTitle("Chỉnh sửa thông tin cửa hàng");
                alerb.setPositiveButton("Chỉnh sửa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(StoreHome.this,EditStore.class);
                        i.putExtra("infoStore",storeList.get(position));
                        i.putExtra("index",position);
                        startActivityForResult(i, REQUEST_CODE_EXAMPLE);
                    }
                });
                alerb.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        APIService.apiService.deleteStore(storeList.get(position).get_id()).enqueue(new Callback<Respone>() {
                            @Override
                            public void onResponse(Call<Respone> call, Response<Respone> response) {
                            }

                            @Override
                            public void onFailure(Call<Respone> call, Throwable t) {
                                Toast.makeText(StoreHome.this, "Server Error!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                        storeList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                AlertDialog alertDialog= alerb.create();
                alertDialog.show();
                return true;
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getListProduct(storeList.get(position).get_id());
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StoreHome.this,CreateStore.class);
                startActivityForResult(i, REQUEST_CODE_EXAMPLE);
            }
        });
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StoreHome.this, ProfileHome.class);
                startActivityForResult(i,3);
            }
        });
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent();
                setResult(MainActivity.RESULT_OK,i);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_EXAMPLE) {
            // resultCode được set bởi DetailActivity
            // RESULT_OK chỉ ra rằng kết quả này đã thành công
            if(resultCode == EditStore.RESULT_OK) {
             adapter.notifyDataSetChanged();
//                Intent intent = getIntent();
//                finish();
//                startActivity(intent);
            }
            else if(resultCode == 700){
                adapter.notifyDataSetChanged();
//                Intent intent = getIntent();
//                finish();
//                startActivity(intent);
            }
            else {
                // DetailActivity không thành công, không có data trả về.
            }
        }
    }
}