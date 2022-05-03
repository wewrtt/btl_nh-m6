package com.example.btlandroidnhom6.thongke;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.btlandroidnhom6.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BieuDoduong extends AppCompatActivity {
    private BarChart barChart ;
    private List<Float> label= new ArrayList<>();
    private List<Float> value= new ArrayList<>();
    private String title= "getTitle()";
    public void anhXa(){
        barChart = findViewById(R.id.BarChart);
        label = (List<Float>) getIntent().getExtras().get("label");
        value = (List<Float>) getIntent().getExtras().get("value");
        title = (String) getIntent().getExtras().get("title");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke_chain_store);
        anhXa();

        int j=0;
        ArrayList<BarEntry> list = new ArrayList();
        for(int i=0;i<label.size();i++){
            list.add(new BarEntry(label.get(i),value.get(i)));
        }

        BarDataSet set2 = new BarDataSet(list, title);
        set2.setLabel(title);
        set2.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set2.setValueTextColor(Color.BLACK);
        set2.setValueTextSize(20f);
        BarData barData = new BarData(set2);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.setDragEnabled(true);
        barChart.invalidate();
        barChart.animateY(2000);

    }
}