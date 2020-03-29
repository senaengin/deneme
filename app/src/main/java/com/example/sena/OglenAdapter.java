package com.example.sena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OglenAdapter extends RecyclerView.Adapter<OglenAdapter.ExampleViewHolder> {
    private List<OglenItem> oglenList;
    private List<OglenItem> oglenListFull;

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

    OglenAdapter(List<OglenItem> oglenList2) {
        this.oglenList = oglenList2;
        this.oglenListFull = new ArrayList(oglenList2);
    }

    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_apps, parent, false));
    }

    public void onBindViewHolder(ExampleViewHolder holder, int position) {
       OglenItem currentItem = (OglenItem) this.oglenList.get(position);
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    public int getItemCount() {
        return this.oglenList.size();
    }


    public void setFilter(List<OglenItem> filterdNames) {
        this.oglenList = filterdNames;
        notifyDataSetChanged();
    }

}