package com.example.btlandroidnhom6.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.Welcome;
import com.example.btlandroidnhom6.login_registor.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Welcom2 extends AppCompatActivity {
    private  PhotoAdapter photoAdapter;
    private CircleIndicator circleIndicator;
    private ViewPager viewPager2;
    private Button btn;
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
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom2);
        anhXa();

        viewPager2.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager2);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Welcom2.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

}