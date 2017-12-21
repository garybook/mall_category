package com.jason.category.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder> {
    private int layoutId;
    private List<? extends Object> data;
    public Context context;
    private OnItemClickListner onItemClickListner;//单击事件

    /**
     * @param context  //上下文
     * @param layoutId //布局id
     * @param data     //数据源
     */
    public RecycleAdapter(Context context, int layoutId, List<? extends Object> data) {
        this.layoutId = layoutId;
        this.data = data;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        final ViewHolder holder = new ViewHolder(v, context);
        //单击事件回调
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListner == null)
                    return;
                onItemClickListner.onItemClickListner(v, holder.getLayoutPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mCallBack != null)
            mCallBack.convert(holder, data.get(position), position);
    }

    @Override
    public int getItemCount() {
        int count = data.size();
        return count;
    }

    public List<? extends Object> getData() {
        return data;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface OnItemClickListner {
        void onItemClickListner(View v, int position);
    }

    CallBack mCallBack;

    public void setCallBack(CallBack CallBack) {
        this.mCallBack = CallBack;
    }

    public interface CallBack {
        <T extends Object> void convert(ViewHolder holder, T bean, int position);
    }

}
