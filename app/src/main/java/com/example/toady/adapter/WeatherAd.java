package com.example.toady.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.toady.R;
import com.example.toady.bean.WeatherBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherAd extends RecyclerView.Adapter<WeatherAd.viewholder> {
    private Context context;
    private List<WeatherBean.ResultBean.FutureBean> list;
    public WeatherAd(Context context, List<WeatherBean.ResultBean.FutureBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public WeatherAd.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.weather_item,null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAd.viewholder viewholder, int i) {
        viewholder.tv_day.setText(list.get(i).getDate());
        viewholder.tv_wendu.setText(list.get(i).getTemperature());
        switch (list.get(i).getWid().getDay()){
            case "00":
                viewholder.imageView.setImageResource(R.drawable.qing0);
                break;
            case "01":
                viewholder.imageView.setImageResource(R.drawable.duoyun1);
                break;
            case "02":
                viewholder.imageView.setImageResource(R.drawable.yin2);
                break;
            case "03":
                viewholder.imageView.setImageResource(R.drawable.zhenyu3);
                break;
            case "04":
                viewholder.imageView.setImageResource(R.drawable.leizhenyu4);
                break;
            case "05":
                viewholder.imageView.setImageResource(R.drawable.leijiabing5);
                break;
            case "06":
                viewholder.imageView.setImageResource(R.drawable.yujiaxue6);
                break;
            case "07":
                viewholder.imageView.setImageResource(R.drawable.xiaoyu7);
                break;
            case "08":
                viewholder.imageView.setImageResource(R.drawable.zhuongyu8);
                break;
            case "09":
                viewholder.imageView.setImageResource(R.drawable.dayu9);
                break;
            case "10":
                viewholder.imageView.setImageResource(R.drawable.baoyu10);
                break;
            case "11":
                viewholder.imageView.setImageResource(R.drawable.dabaoyu11);
                break;
            case "12":
                viewholder.imageView.setImageResource(R.drawable.tedabaoyu12);
                break;
            case "13":
                viewholder.imageView.setImageResource(R.drawable.zhenxue13);
                break;
            case "14":
                viewholder.imageView.setImageResource(R.drawable.xiaoxue14);
                break;
            case "15":
                viewholder.imageView.setImageResource(R.drawable.zhongxue15);
                break;
            case "16":
                viewholder.imageView.setImageResource(R.drawable.daxue16);
                break;
            case "17":
                viewholder.imageView.setImageResource(R.drawable.baoxue17);
                break;
            case "18":
                viewholder.imageView.setImageResource(R.drawable.wu18);
                break;
            case "19":
                viewholder.imageView.setImageResource(R.drawable.dongyu19);
                break;
            case "20":
                viewholder.imageView.setImageResource(R.drawable.shachengbao20);
                break;
            case "21":
                viewholder.imageView.setImageResource(R.drawable.xiaozhongyu21);
                break;
            case "22":
                viewholder.imageView.setImageResource(R.drawable.zhongdayu22);
                break;
            case "23":
                viewholder.imageView.setImageResource(R.drawable.dabaoyu23);
                break;
            case "24":
                viewholder.imageView.setImageResource(R.drawable.daobaoyu24);
                break;
            case "25":
                viewholder.imageView.setImageResource(R.drawable.tedabaoyu25);
                break;
            case "26":
                viewholder.imageView.setImageResource(R.drawable.xiaozhongxue26);
                break;
            case "27":
                viewholder.imageView.setImageResource(R.drawable.zhongdaxue27);
                break;
            case "28":
                viewholder.imageView.setImageResource(R.drawable.dabaoxue28);
                break;
            case "29":
                viewholder.imageView.setImageResource(R.drawable.fucheng29);
                break;
            case "30":
                viewholder.imageView.setImageResource(R.drawable.yangsha30);
                break;
            case "31":
                viewholder.imageView.setImageResource(R.drawable.qiangshachengbao31);
                break;
            case "53":
                viewholder.imageView.setImageResource(R.drawable.mai53);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class viewholder extends RecyclerView.ViewHolder{
private TextView tv_day,tv_wendu;
private ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv_day=itemView.findViewById(R.id.item_tv_day);
            tv_wendu=itemView.findViewById(R.id.item_tv_wendu);
            imageView=itemView.findViewById(R.id.item_iv);
        }
    }
}
