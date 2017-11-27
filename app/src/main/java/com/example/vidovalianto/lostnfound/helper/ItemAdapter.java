package com.example.vidovalianto.lostnfound.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vidovalianto.lostnfound.Model.Item;
import com.example.vidovalianto.lostnfound.R;

import java.util.ArrayList;

/**
 * Created by VidoValianto on 11/28/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private ArrayList<Item> items;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView mDay, mLocation, mBarang;


        public ViewHolder(View itemView) {
            super(itemView);
            mBarang = (TextView) itemView.findViewById(R.id.tv_namabarang);
            mDay = (TextView) itemView.findViewById(R.id.tv_day);
            mLocation = (TextView) itemView.findViewById(R.id.tv_location);

        }
    }

    public ItemAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {


        holder.mBarang.setText(items.get(position).getBarang());
        holder.mDay.setText(items.get(position).getHari());
        holder.mLocation.setText(items.get(position).getLokasi());

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
