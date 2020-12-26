package com.example.shopee;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.viewHoder> {
    ArrayList<Product> listProducts;
    Context context;
    int layout;

    public ProductAdapter(ArrayList<Product> listProducts, Context context, int layout) {
        this.listProducts = listProducts;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = inflater.inflate(layout,parent,false);
        return new viewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder holder, int position) {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        holder.tvName.setText(listProducts.get(position).getName());

        Picasso.get().load(listProducts.get(position).getImg()).into(holder.img, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

        holder.gia_cu.setText(fmt.format(Integer.parseInt(listProducts.get(position).getGia_cu())));
        holder.gia_moi.setText(fmt.format(Integer.parseInt(listProducts.get(position).getGia_moi())));


    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder{
        TextView tvName, gia_cu,gia_moi;
        ImageView img;
        public viewHoder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            img = (ImageView) itemView.findViewById(R.id.img_product);
            gia_cu = (TextView) itemView.findViewById(R.id.tv_gia_cu);
            gia_cu.setPaintFlags(gia_cu.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            gia_moi= (TextView) itemView.findViewById(R.id.tv_gia_moi);
        }
    }
}
