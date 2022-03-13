package com.example.btlandroidnhom6.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.btlandroidnhom6.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Test_Screem extends AppCompatActivity {
    private  PhotoAdapter photoAdapter;
    private CircleIndicator circleIndicator;
    private ViewPager viewPager2;
    private List<Photo> getListPhoto(){
        List<Photo> list= new ArrayList<>();
        list.add(new Photo(R.drawable.welcome1));
        list.add(new Photo(R.drawable.welcome2));
        list.add(new Photo(R.drawable.welcome3));
        return  list;
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screem);

        viewPager2 = findViewById(R.id.viewPager2);
        circleIndicator= findViewById(R.id.CircleIndicator);

        photoAdapter = new PhotoAdapter(this,getListPhoto());
        viewPager2.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager2);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }
}