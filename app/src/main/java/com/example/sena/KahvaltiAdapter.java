package com.example.sena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KahvaltiAdapter extends RecyclerView.Adapter<KahvaltiAdapter.ExampleViewHolder> {
    private List<KahvaltiItem> kahvaltiList;
    private List<KahvaltiItem> kahvaltiListFull;

    class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;  //silindi.
        TextView textView1;
        TextView textView2;

        ExampleViewHolder(View itemView) {
            super(itemView);
            this.textView1 = (TextView) itemView.findViewById(R.id.textview);
            this.textView2 = (TextView) itemView.findViewById(R.id.textview2);
        }
    }

   KahvaltiAdapter(List<KahvaltiItem> kahvaltiList2) {
        this.kahvaltiList = kahvaltiList2;
        this.kahvaltiListFull = new ArrayList(kahvaltiList2);
    }

    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_apps, parent, false));
    }

    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        KahvaltiItem currentItem = (KahvaltiItem) this.kahvaltiList.get(position);
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    public int getItemCount() {
        return this.kahvaltiList.size();
    }


    public void setFilter(List<KahvaltiItem> filterdNames) {
        this.kahvaltiList = filterdNames;
        notifyDataSetChanged();
    }

}
