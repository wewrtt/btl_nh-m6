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

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.ResponeProduct;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.store.AddProductForStore;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductHome extends AppCompatActivity {
    private Store store;
    private  static  final  String TAG= ProductHome.class.getSimpleName();
    private GridView gridView;
    public static List<Product> listProduct;
    public static List<Product> listProductInStore;
    private ListProductAdapter adapter;
    private String store_id;
    private Button btn_add;
    public void anhxa(){
        gridView = findViewById(R.id.GridView_ListProduct);
        btn_add=findViewById(R.id.btn_add);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        anhxa();
        listProduct = (List<Product>) getIntent().getExtras().get("listProduct");
        listProductInStore = (List<Product>) getIntent().getExtras().get("listProduct");
        store_id= (String) getIntent().getExtras().get("store_id");
//        listProduct = new ArrayList<>();
//        listProduct.add(new Product("a","a","a",12));
//        listProduct.add(new Product("a","a","a",12));
//        listProduct.add(new Product("a","a","a",12));
        adapter = new ListProductAdapter(ProductHome.this,listProductInStore,R.layout.product);
        gridView.setAdapter(adapter);
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
                        i.putExtra("infoProduct",listProductInStore.get(position));
                        i.putExtra("position",position);
                        activityResultLauncher.launch(i);
                    }
                });
                alerb.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProductHome.this, "Bạn không thể xóa", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog= alerb.create();
                alertDialog.show();
                return true;
            }

        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllProduct();
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
                        int quantity= (Integer) i.getExtras().get("quantity");
                        int position= (int) i.getExtras().get("index");
                        listProduct.get(position).setQuantity(quantity);
                        adapter.notifyDataSetChanged();
                        Log.e(TAG,"Hoang Duc Thang "+ quantity+" ");
                    }
                    else if(result.getResultCode()==706){
                        Intent i= result.getData();
                        Product product= (Product) i.getExtras().get("product");
                        Log.e("AA",product.get_id());
                        boolean check=true;
                        for(int j=0;j<listProductInStore.size();j++){
                            if(listProductInStore.get(j).get_id().equals(product.get_id())){
                                listProductInStore.set(j,product);
                                check=false;
                                break;
                            }
                        }
                        if (check){
                            listProductInStore.add(product);
                        }

                        adapter.notifyDataSetChanged();
                    }

                }
            }
    );
    public  List<Product> getAllProduct() {
        APIService.apiService.getAllProduct(LoginActivity.mainUser.get_id()).enqueue(new Callback<ResponeProduct>() {
            @Override
            public void onResponse(Call<ResponeProduct> call, Response<ResponeProduct> response) {
                ResponeProduct res = response.body();
                if (res.getStatusCode() == 200) {
                    listProduct = res.getData();
                    Intent i= new Intent(ProductHome.this, AddProductForStore.class);
                    i.putExtra("listProduct", (Serializable) listProduct);
                    i.putExtra("store_id",store_id);
                    activityResultLauncher.launch(i);
                }
            }

            @Override
            public void onFailure(Call<ResponeProduct> call, Throwable t) {

            }
        });
        return listProduct;
    }
}