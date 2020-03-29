package com.example.sena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AksamAdapter extends RecyclerView.Adapter<AksamAdapter.ExampleViewHolder> {
    private List<AksamItem> aksamList;
    private List<AksamItem> aksamListFull;

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

    AksamAdapter(List<AksamItem> aksamList2) {
        this.aksamList = aksamList2;
        this.aksamListFull = new ArrayList(aksamList2);
    }

    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_apps, parent, false));
    }

    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        AksamItem currentItem = (AksamItem) this.aksamList.get(position);
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    public int getItemCount() {
        return this.aksamList.size();
    }


    public void setFilter(List<AksamItem> filterdNames) {
        this.aksamList = filterdNames;
        notifyDataSetChanged();
    }

}

