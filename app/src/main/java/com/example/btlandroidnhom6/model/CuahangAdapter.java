package com.example.btlandroidnhom6.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btlandroidnhom6.Home.MainActivity;
import com.example.btlandroidnhom6.R;

import java.util.ArrayList;
import java.util.List;

public class CuahangAdapter extends RecyclerView.Adapter<CuahangAdapter.cuahangviewholder> {
    Context con;
    List<Category> cuahanglist;

    public CuahangAdapter(MainActivity mainActivity, ArrayList<Category> datalist) {
        cuahanglist= new ArrayList<>();
        cuahanglist=datalist;
        con=mainActivity;
    }

    @NonNull
    @Override
    public cuahangviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(con).inflate(R.layout.layout_item_rows,parent,false);
        return new cuahangviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cuahangviewholder holder, int position) {
        holder.cuahangimageview.setImageResource(cuahanglist.get(position).getImageurl());
    }

    @Override
    public int getItemCount() {
        return cuahanglist.size();//5
    }

    public static class cuahangviewholder extends RecyclerView.ViewHolder{

        ImageView cuahangimageview;

        public cuahangviewholder(@NonNull View itemView) {
            super(itemView);
            cuahangimageview= itemView.findViewById(R.id.imageView);
        }

    }
}