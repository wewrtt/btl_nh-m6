package com.example.btlandroidnhom6.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroidnhom6.R;
import com.example.btlandroidnhom6.model.Product;

import java.util.List;

public class ListProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> listProduct;
    private  int layout;

    public ListProductAdapter(Context context, List<Product> listProduct, int layout) {
        this.context = context;
        this.listProduct = listProduct;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listProduct.size();
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
        private ImageView img;
        private TextView txtName,txtprice,txtdescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListProductAdapter.ViewHolder viewHolder;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,parent,false);
            viewHolder = new ListProductAdapter.ViewHolder();
            viewHolder.img=convertView.findViewById(R.id.anh);
            viewHolder.txtName=(TextView) convertView.findViewById(R.id.txt_nameProduct);
            viewHolder.txtprice=convertView.findViewById(R.id.txt_price);
            viewHolder.txtdescription=convertView.findViewById(R.id.txt_descripton);
            convertView.setTag(viewHolder);
        }
        else viewHolder =(ListProductAdapter.ViewHolder) convertView.getTag();
        int idanh=Integer.parseInt(listProduct.get(position).getImages());
        //Picasso.get().load().into(viewHolder.img);
        viewHolder.img.setImageResource(idanh);
        viewHolder.txtName.setText(listProduct.get(position).getName());
        viewHolder.txtprice.setText(listProduct.get(position).getPrice()+"");
        viewHolder.txtdescription.setText(listProduct.get(position).getDescription());


        return convertView;
    }
}
