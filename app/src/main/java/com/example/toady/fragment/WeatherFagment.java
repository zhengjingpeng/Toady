package com.example.toady.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.toady.R;
import com.example.toady.Utils.MyItemDecoration;
import com.example.toady.adapter.WeatherAd;
import com.example.toady.bean.WeatherBean;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherFagment extends BaseFragment {
    private TextView tv_city,tv_duoyun,tv_wendu,tv_fengli,tv_day,tv_qing;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private OkHttpClient okHttpClient=new OkHttpClient();
    private List<WeatherBean.ResultBean.FutureBean> list=new ArrayList<>();
    private Gson gson = new Gson();
    private WeatherAd adapter;
    @Override
    protected void getData() {

    }

    @Override
    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        View rootview = inflater.inflate(R.layout.fragment_3, container, false);
        initView(rootview);
        getdata();
        initListen();
        return rootview;
    }

    private void initListen() {
        tv_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getContext())
                        .title("选择城市")
                        .content("")
                        .inputType(InputType.TYPE_CLASS_TEXT)// InputType.TYPE_TEXT_VARIATION_PASSWORD
                        .input("请输入城市名", getContext().getSharedPreferences("weatherdata", Context.MODE_PRIVATE).getString("城市", "汕头"), new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                                String city=input.toString();
                                SharedPreferences sp = getContext().getSharedPreferences("weatherdata", Context.MODE_PRIVATE);
                                sp.edit().putString("cs",city);
                                tv_city.setText(input.toString());
                                final String url="http://apis.juhe.cn/simpleWeather/query?city="+city+"&key=adf5e65eaa80993854c46bd2bce5f364";
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Request request=new Request.Builder().url(url).build();
                                        try {
                                            Response response=okHttpClient.newCall(request).execute();
                                            String s=response.body().string();
                                            Log.i("ssssss",s);
                                            WeatherBean weatherBean=gson.fromJson(s,WeatherBean.class);
                                             list=weatherBean.getResult().getFuture();
                                            final WeatherBean.ResultBean.RealtimeBean realtime = weatherBean.getResult().getRealtime();

                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    tv_wendu.setText(realtime.getTemperature());
                                                    tv_day.setText(list.get(0).getDate());
                                                    tv_duoyun.setText(list.get(0).getWeather());
                                                    tv_fengli.setText(realtime.getDirect()+realtime.getPower());
                                                    tv_qing.setText(realtime.getInfo());
                                                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                                                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                                    recyclerView.setLayoutManager(linearLayoutManager);
                                                    adapter=new WeatherAd(getActivity(),list);
                                                    recyclerView.setAdapter(adapter);
                                                    switch (list.get(0).getWid().getDay()){
                                                        case "00":
                                                            imageView.setImageResource(R.drawable.qing0);
                                                            break;
                                                        case "01":
                                                            imageView.setImageResource(R.drawable.duoyun1);
                                                            break;
                                                        case "02":
                                                            imageView.setImageResource(R.drawable.yin2);
                                                            break;
                                                        case "03":
                                                            imageView.setImageResource(R.drawable.zhenyu3);
                                                            break;
                                                        case "04":
                                                            imageView.setImageResource(R.drawable.leizhenyu4);
                                                            break;
                                                        case "05":
                                                            imageView.setImageResource(R.drawable.leijiabing5);
                                                            break;
                                                        case "06":
                                                            imageView.setImageResource(R.drawable.yujiaxue6);
                                                            break;
                                                        case "07":
                                                            imageView.setImageResource(R.drawable.xiaoyu7);
                                                            break;
                                                        case "08":
                                                            imageView.setImageResource(R.drawable.zhuongyu8);
                                                            break;
                                                        case "09":
                                                            imageView.setImageResource(R.drawable.dayu9);
                                                            break;
                                                        case "10":
                                                            imageView.setImageResource(R.drawable.baoyu10);
                                                            break;
                                                        case "11":
                                                            imageView.setImageResource(R.drawable.dabaoyu11);
                                                            break;
                                                        case "12":
                                                            imageView.setImageResource(R.drawable.tedabaoyu12);
                                                            break;
                                                        case "13":
                                                            imageView.setImageResource(R.drawable.zhenxue13);
                                                            break;
                                                        case "14":
                                                            imageView.setImageResource(R.drawable.xiaoxue14);
                                                            break;
                                                        case "15":
                                                            imageView.setImageResource(R.drawable.zhongxue15);
                                                            break;
                                                        case "16":
                                                            imageView.setImageResource(R.drawable.daxue16);
                                                            break;
                                                        case "17":
                                                            imageView.setImageResource(R.drawable.baoxue17);
                                                            break;
                                                        case "18":
                                                            imageView.setImageResource(R.drawable.wu18);
                                                            break;
                                                        case "19":
                                                            imageView.setImageResource(R.drawable.dongyu19);
                                                            break;
                                                        case "20":
                                                            imageView.setImageResource(R.drawable.shachengbao20);
                                                            break;
                                                        case "21":
                                                            imageView.setImageResource(R.drawable.xiaozhongyu21);
                                                            break;
                                                        case "22":
                                                            imageView.setImageResource(R.drawable.zhongdayu22);
                                                            break;
                                                        case "23":
                                                            imageView.setImageResource(R.drawable.dabaoyu23);
                                                            break;
                                                        case "24":
                                                            imageView.setImageResource(R.drawable.daobaoyu24);
                                                            break;
                                                        case "25":
                                                            imageView.setImageResource(R.drawable.tedabaoyu25);
                                                            break;
                                                        case "26":
                                                            imageView.setImageResource(R.drawable.xiaozhongxue26);
                                                            break;
                                                        case "27":
                                                            imageView.setImageResource(R.drawable.zhongdaxue27);
                                                            break;
                                                        case "28":
                                                            imageView.setImageResource(R.drawable.dabaoxue28);
                                                            break;
                                                        case "29":
                                                            imageView.setImageResource(R.drawable.fucheng29);
                                                            break;
                                                        case "30":
                                                            imageView.setImageResource(R.drawable.yangsha30);
                                                            break;
                                                        case "31":
                                                            imageView.setImageResource(R.drawable.qiangshachengbao31);
                                                            break;
                                                        case "53":
                                                            imageView.setImageResource(R.drawable.mai53);
                                                            break;




                                                    }

                                                }
                                            });
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                            }
                        }).show();
            }
        });

    }

    private void getdata() {
        tv_city.setText(getContext().getSharedPreferences("weatherdata", Context.MODE_PRIVATE).getString("城市", "佛山"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getContext().getSharedPreferences("weatherdata", Context.MODE_PRIVATE);
                String url="http://apis.juhe.cn/simpleWeather/query?city="+sp.getString("城市", "佛山")+"&key=adf5e65eaa80993854c46bd2bce5f364";
                Request request=new Request.Builder().url(url).build();
                try {
                    Response response=okHttpClient.newCall(request).execute();
                    String s=response.body().string();
                    Log.i("ssssss",s);
                    WeatherBean weatherBean=gson.fromJson(s,WeatherBean.class);
                    final WeatherBean.ResultBean.RealtimeBean realtime = weatherBean.getResult().getRealtime();
                    list=weatherBean.getResult().getFuture();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_wendu.setText(realtime.getTemperature());
                            tv_day.setText(list.get(0).getDate());
                            tv_duoyun.setText(realtime.getInfo());
                            tv_fengli.setText(realtime.getDirect()+realtime.getPower());
                            tv_qing.setText(realtime.getInfo());
                            switch (list.get(0).getWid().getDay()){
                                case "00":
                                    imageView.setImageResource(R.drawable.qing0);
                                    break;
                                case "01":
                                    imageView.setImageResource(R.drawable.duoyun1);
                                    break;
                                case "02":
                                    imageView.setImageResource(R.drawable.yin2);
                                    break;
                                case "03":
                                    imageView.setImageResource(R.drawable.zhenyu3);
                                    break;
                                case "04":
                                    imageView.setImageResource(R.drawable.leizhenyu4);
                                    break;
                                case "05":
                                    imageView.setImageResource(R.drawable.leijiabing5);
                                    break;
                                case "06":
                                    imageView.setImageResource(R.drawable.yujiaxue6);
                                    break;
                                case "07":
                                    imageView.setImageResource(R.drawable.xiaoyu7);
                                    break;
                                case "08":
                                    imageView.setImageResource(R.drawable.zhuongyu8);
                                    break;
                                case "09":
                                    imageView.setImageResource(R.drawable.dayu9);
                                    break;
                                case "10":
                                    imageView.setImageResource(R.drawable.baoyu10);
                                    break;
                                case "11":
                                    imageView.setImageResource(R.drawable.dabaoyu11);
                                    break;
                                case "12":
                                    imageView.setImageResource(R.drawable.tedabaoyu12);
                                    break;
                                case "13":
                                    imageView.setImageResource(R.drawable.zhenxue13);
                                    break;
                                case "14":
                                    imageView.setImageResource(R.drawable.xiaoxue14);
                                    break;
                                case "15":
                                    imageView.setImageResource(R.drawable.zhongxue15);
                                    break;
                                case "16":
                                    imageView.setImageResource(R.drawable.daxue16);
                                    break;
                                case "17":
                                    imageView.setImageResource(R.drawable.baoxue17);
                                    break;
                                case "18":
                                    imageView.setImageResource(R.drawable.wu18);
                                    break;
                                case "19":
                                    imageView.setImageResource(R.drawable.dongyu19);
                                    break;
                                case "20":
                                    imageView.setImageResource(R.drawable.shachengbao20);
                                    break;
                                case "21":
                                    imageView.setImageResource(R.drawable.xiaozhongyu21);
                                    break;
                                case "22":
                                    imageView.setImageResource(R.drawable.zhongdayu22);
                                    break;
                                case "23":
                                    imageView.setImageResource(R.drawable.dabaoyu23);
                                    break;
                                case "24":
                                    imageView.setImageResource(R.drawable.daobaoyu24);
                                    break;
                                case "25":
                                    imageView.setImageResource(R.drawable.tedabaoyu25);
                                    break;
                                case "26":
                                    imageView.setImageResource(R.drawable.xiaozhongxue26);
                                    break;
                                case "27":
                                    imageView.setImageResource(R.drawable.zhongdaxue27);
                                    break;
                                case "28":
                                    imageView.setImageResource(R.drawable.dabaoxue28);
                                    break;
                                case "29":
                                    imageView.setImageResource(R.drawable.fucheng29);
                                    break;
                                case "30":
                                    imageView.setImageResource(R.drawable.yangsha30);
                                    break;
                                case "31":
                                    imageView.setImageResource(R.drawable.qiangshachengbao31);
                                    break;
                                case "53":
                                    imageView.setImageResource(R.drawable.mai53);
                                    break;




                            }
                            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            adapter=new WeatherAd(getActivity(),list);
                            recyclerView.setAdapter(adapter);
                            recyclerView.addItemDecoration(new DividerItemDecoration(
                                    getActivity(), DividerItemDecoration.VERTICAL));
                            //添加带颜色分割线

                        }
                    });


                    /*list = weatherData.getResult().get(weatherData.getResult().size() - 1).getFuture();*/
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void initView(View rootview) {
        tv_city=rootview.findViewById(R.id.city);
        tv_duoyun=rootview.findViewById(R.id.duoyun);
        tv_wendu=rootview.findViewById(R.id.wendu);
        tv_day=rootview.findViewById(R.id.day);
        tv_fengli=rootview.findViewById(R.id.fengli);
        tv_qing=rootview.findViewById(R.id.qing);
        imageView=rootview.findViewById(R.id.iv);
        recyclerView=rootview.findViewById(R.id.weather_lv);

    }

}
