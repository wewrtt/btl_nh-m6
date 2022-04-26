package com.example.btlandroidnhom6.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.Welcome;
import com.example.btlandroidnhom6.api.APIService;
import com.example.btlandroidnhom6.login_registor.LoginActivity;
import com.example.btlandroidnhom6.model.Respone;
import com.example.btlandroidnhom6.model.User;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcom2 extends AppCompatActivity {
    private static final  String TAG=Welcom2.class.getSimpleName();
    private  PhotoAdapter photoAdapter;
    private CircleIndicator circleIndicator;
    private ViewPager viewPager2;
    private Button btn;
    public static User user;
    private List<Photo> getListPhoto(){
        List<Photo> list= new ArrayList<>();
        list.add(new Photo(R.drawable.welcome1));
        list.add(new Photo(R.drawable.welcome2));
        list.add(new Photo(R.drawable.welcome3));
        return  list;
    };
    private  void anhXa(){
        viewPager2 = findViewById(R.id.viewPager2);
        circleIndicator= findViewById(R.id.CircleIndicator);
        photoAdapter = new PhotoAdapter(this,getListPhoto());
        btn= findViewById(R.id.button);
        user= LoginActivity.mainUser;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom2);
        anhXa();

        viewPager2.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager2);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        Log.e(TAG,user.get_id());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(Welcom2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}