package com.example.sena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DigerAdapter extends RecyclerView.Adapter<DigerAdapter.ExampleViewHolder>{
    private List<DigerItem> digerList;
    private List<DigerItem> digerListFull;

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

    DigerAdapter(List<DigerItem> digerList2) {
        this.digerList = digerList2;
        this.digerListFull = new ArrayList(digerList2);
    }

    public DigerAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DigerAdapter.ExampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_apps, parent, false));
    }

    public void onBindViewHolder(DigerAdapter.ExampleViewHolder holder, int position) {
        DigerItem currentItem = (DigerItem) this.digerList.get(position);
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    public int getItemCount() {
        return this.digerList.size();
    }


    public void setFilter(List<DigerItem> filterdNames) {
        this.digerList = filterdNames;
        notifyDataSetChanged();
    }

}
