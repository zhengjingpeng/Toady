package com.example.toady.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.toady.R;
import com.example.toady.adapter.CaiRvAappter;
import com.example.toady.adapter.WeatherAd;
import com.example.toady.bean.CaiBean;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewFagment extends BaseFragment {
    private EditText ed_cai,ed_number;
    private Button btn_search;
    private OkHttpClient okHttpClient;
    private RecyclerView recyclerView;
    private List<CaiBean.ResultBean.ListBean> list;
    @Override
    protected void getData() {

    }

    @Override
    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        View rootview = inflater.inflate(R.layout.fragment_2, container, false);
        initView(rootview);
        okHttpClient=new OkHttpClient();
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initdata();
            }
        });


        return rootview;
    }

    private void initdata() {
        final int number = Integer.parseInt(ed_number.getText().toString());
        final String name = ed_cai.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //https://api.jisuapi.com/recipe/search?keyword="+name+"&num="+number+"&appkey=f43d695de4bb3645
                String url="https://api.jisuapi.com/recipe/search?keyword="+name +"&num="+number+"&appkey=f43d695de4bb3645";
                Request request=new Request.Builder().url(url).build();
                try {
                    Response response=okHttpClient.newCall(request).execute();
                    String s = response.body().string();
                  Log.i("cccccccc",s);
                    Gson gson=new Gson();
                    CaiBean caiBean=gson.fromJson(s,CaiBean.class);
                    list=caiBean.getResult().getList();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            CaiRvAappter adapter=new CaiRvAappter(getActivity(),list);
                            recyclerView.setAdapter(adapter);
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView(View view) {
        ed_cai=view.findViewById(R.id.cai_name);
        ed_number=view.findViewById(R.id.cai_number);
        btn_search=view.findViewById(R.id.cai_btn);
        recyclerView=view.findViewById(R.id.cai_rv);
    }
}
