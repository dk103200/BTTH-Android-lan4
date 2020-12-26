package com.example.shopee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class FlashSaleAdapter extends RecyclerView.Adapter<FlashSaleAdapter.viewHoder> {
    ArrayList<FlashSale> flashSales;
    Context context;
    int layout;

    public FlashSaleAdapter(ArrayList<FlashSale> flashSales, Context context, int layout) {
        this.flashSales = flashSales;
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
        holder.tvGia.setText(fmt.format(flashSales.get(position).getGia()));
        holder.img.setImageResource(flashSales.get(position).getImg());
        holder.sell.setText("ĐÃ BÁN " +flashSales.get(position).getSell());


    }

    @Override
    public int getItemCount() {
        return flashSales.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder{
        TextView tvGia, sell;
        ImageView img;
        public viewHoder(@NonNull View itemView) {
            super(itemView);
            tvGia = (TextView) itemView.findViewById(R.id.tv_gia);
            img = (ImageView) itemView.findViewById(R.id.img_flashsale);
            sell = (TextView) itemView.findViewById(R.id.sell);
        }
    }
}
