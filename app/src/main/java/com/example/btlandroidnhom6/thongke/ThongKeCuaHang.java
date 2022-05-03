package com.example.btlandroidnhom6.thongke;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.btlandroidnhom6.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ThongKeCuaHang extends AppCompatActivity {
    private PieChart pieChart;
    private List<Float> label= new ArrayList<>();
    private List<Float> value= new ArrayList<>();
    private String title= "getTitle()";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke_store);
        pieChart = findViewById(R.id.PieChart);
        label = (List<Float>) getIntent().getExtras().get("label");
        value = (List<Float>) getIntent().getExtras().get("value");
        title = (String) getIntent().getExtras().get("title");

        ArrayList<PieEntry> pieEntry = new ArrayList<>();
        for(int i=0;i<label.size();i++){
            pieEntry.add(new PieEntry(value.get(i),label.get(i)+""));
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntry,title);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(20f);

        PieData pieData= new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.setCenterTextSize(20f);
        pieChart.getDescription().setEnabled(false);
        pieChart.animateX(2000);

    }
}