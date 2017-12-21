package com.jason.category.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ViewHolder extends RecyclerView.ViewHolder {
    View convertView;
    Context context;

    public ViewHolder(View itemView, Context context) {
        super(itemView);
        this.convertView = itemView;
        this.context = context;
    }

    public View getItemView() {
        return convertView;
    }

    public void setText(int id, String text) {
        TextView tx = (TextView) convertView.findViewById(id);
        tx.setText(text);
    }

    public View getView(int id) {
        return convertView.findViewById(id);
    }


}
