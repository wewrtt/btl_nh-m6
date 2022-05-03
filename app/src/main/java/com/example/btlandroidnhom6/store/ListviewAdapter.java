package com.example.btlandroidnhom6.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.model.Store;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListviewAdapter extends BaseAdapter {
    private  Context context;
    private List<Store> listStore;
    private  int layout;

    public ListviewAdapter(Context context, List<Store> listStore, int layout) {
        this.context = context;
        this.listStore = listStore;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listStore.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private  class ViewHolder{
        private  ImageView img;
        private  TextView txtDiaChi,txtLoaiHang,txtDoanhThu,txtQuanLy;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              convertView = inflater.inflate(layout,parent,false);
              viewHolder = new ViewHolder();
              viewHolder.img=convertView.findViewById(R.id.anh);
              viewHolder.txtDiaChi=(TextView) convertView.findViewById(R.id.txt_diachi);
              viewHolder.txtDoanhThu=convertView.findViewById(R.id.txt_doanhthu);
              viewHolder.txtLoaiHang=convertView.findViewById(R.id.txt_loaihang);
              viewHolder.txtQuanLy=convertView.findViewById(R.id.txt_quanly);
              convertView.setTag(viewHolder);
        }
        else viewHolder =(ViewHolder) convertView.getTag();
        Picasso.get().load(listStore.get(position).getImageUrl()).into(viewHolder.img);
        viewHolder.txtDiaChi.setText(listStore.get(position).getAddress());
        viewHolder.txtDoanhThu.setText(listStore.get(position).getPhoneNumber());
        viewHolder.txtLoaiHang.setText(listStore.get(position).getEmail());
        viewHolder.txtQuanLy.setText(listStore.get(position).getName());

        return convertView;
    }

}
