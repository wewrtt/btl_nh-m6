package com.example.btlandroidnhom6.api;

import com.example.btlandroidnhom6.model.NewRespone;
import com.example.btlandroidnhom6.model.NewRespone1;
import com.example.btlandroidnhom6.model.Product;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.ResponeProduct;
import com.example.btlandroidnhom6.model.ResponeUser;
import com.example.btlandroidnhom6.model.ResponseStore;
import com.example.btlandroidnhom6.model.Stock;
import com.example.btlandroidnhom6.model.Store;
import com.example.btlandroidnhom6.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

// .baseUrl("http://")192.168.1.101:8080 kết nói ko wifi
public interface APIService {
    APIService apiService= new Retrofit.Builder()
            .baseUrl("https://a669-113-22-94-208.ap.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService.class);
    //Login-Logout
    @POST("/auth/login/web")
    Call<Respone> login(@Body User user);
    //User
    @POST("/user")
    Call<Respone> registor(@Body User user);
    //Store
    @GET("/cua-hang/user/{idUser}/child")
    Call<ResponseStore> getListStore(@Path("idUser") String idUser);
    @GET("/cua-hang/{id}")
    Call<Respone> getStore(@Path("id") String id);
    @PUT("/cua-hang/{id}")
    Call<Respone> putStore(@Path("id") String id, @Body Store store);
    @DELETE("/cua-hang/{id}")
    Call<Respone> deleteStore(@Path("id") String id);
    @POST("/cua-hang")
    Call<Respone> postStore(@Body Store store);
    //Product
    @GET("/san-pham/cua-hang/{idStore}")
    Call<ResponeProduct> getListProduct(@Path("idStore") String idStore);
    @GET("/san-pham/{id}")
    Call<Respone> getProduct(@Path("id") String id);
    @GET("/san-pham/cua-hang/user/{userID}")
    Call<ResponeProduct> getAllProduct(@Path("userID") String id);
    @PUT("/san-pham/{id}")
    Call<Respone> putProduct(@Path("id") String id,@Body Product a);
    @DELETE("/san-pham/{id}")
    Call<Respone> deleteProduct(@Path("id") String id);
    @POST("/san-pham")
    Call<Respone> postProduct(@Body Product sanpham);
    //Category
//    @GET("/category/all/{id}")
//    Call<ResponseCategory> getListCategory(@Path("id") String id);
    @GET("/category/{id}")
    Call<Respone> getCategory(@Path("id") String id);
    @PUT("/category/{id}")
    Call<Respone> putCategory(@Path("id") String id);
    @DELETE("/category/{id}")
    Call<Respone> deleteCategory(@Path("id") String id);
    @POST("/category")
    Call<Respone> postCategory(@Body Product sanpham);
    // stock
    @POST("/kho-san-pham/phan-kho/{userId}")
    Call<Respone> postProductForStore(@Path("userId") String userId,@Body Stock stock);
    // thong ke
    @GET("/kho-san-pham/doanh-thu/chuoi-cua-hang/user/{userId}")
    Call<NewRespone1> getDoanhthuChuoiCuaHang(@Path("userId") String id);
    @GET("/kho-san-pham/doanh-thu/chuoi-cua-hang/{userId}")
    Call<NewRespone> getDoanhthuCuaHang(@Path("userId") String id);


}
