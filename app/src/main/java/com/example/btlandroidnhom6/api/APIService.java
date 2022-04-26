package com.example.btlandroidnhom6.api;

import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.ResponeUser;
import com.example.btlandroidnhom6.model.ResponseStore;
import com.example.btlandroidnhom6.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

// .baseUrl("http://")192.168.1.101:8080 kết nói ko wifi
public interface APIService {
    APIService apiService= new Retrofit.Builder()
            .baseUrl("http://10.170.41.40:3001")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService.class);
    @POST("/user/registor")
    Call<Respone> registor(@Body User user);

    @POST("/auth/login/web")
    Call<Respone> login(@Body User user);
    @POST("/user/findPassword")
    Call<Respone> findPassword(@Body User user);

    @GET("/user/getList")
    Call<ResponeUser> getList();
    @GET("/cua-hang/user/{userId}")
    Call<ResponseStore> getListStore(@Path("userId") String userId);
}
