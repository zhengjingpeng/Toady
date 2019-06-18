package com.example.toady.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.toady.CaiActivity;
import com.example.toady.R;
import com.example.toady.bean.CaiBean;
import com.example.toady.bean.Data;

import java.util.List;

public class CaiRvAappter extends RecyclerView.Adapter<CaiRvAappter.viewholder> {
    public CaiRvAappter(Context context, List<CaiBean.ResultBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<CaiBean.ResultBean.ListBean> list;
    @NonNull
    @Override
    public CaiRvAappter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_cai,null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaiRvAappter.viewholder viewholder, final int i) {
        viewholder.tv_name.setText(list.get(i).getName());
        Glide
                .with(context)
                .load(list.get(i).getPic())
                .error(R.mipmap.ic_launcher)
                .into(viewholder.iv_pic);
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, CaiActivity.class);
                Data.hashMap.put("bean",list.get(i));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class viewholder extends RecyclerView.ViewHolder{
private TextView tv_name;
private ImageView iv_pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.item_name);
            iv_pic=itemView.findViewById(R.id.item_pic);
        }
    }
}
