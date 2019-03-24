package com.example.toady.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.toady.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewFagment extends BaseFragment {
    @Override
    protected void getData() {

    }

    @Override
    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        View rootview = inflater.inflate(R.layout.fragment_2, container, false);
        List<Map<String, Object>> mylistList=new
                ArrayList<Map<String,Object>>();
        Map<String, Object> map1=new
                HashMap<String,Object>();
        map1.put("logo", R.drawable. weixin );
        map1.put("title", "微信");
        map1.put("content", "微信 是腾讯公司推出的供即时通讯服务的免费应用程序。");
                mylistList.add(map1);

        Map<String, Object> map2=new
                HashMap<String,Object>();
        map2.put("logo", R.drawable. yixin );
        map2.put("title", "易信");
        map2.put("content", "易信是由网易和中国电信联合开发的一款免费聊天软件。");
                mylistList.add(map2);

        Map<String, Object> map3=new
                HashMap<String,Object>();
        map3.put("logo", R.drawable. miliao );
        map3.put("title", "米聊");
        map3.put("content", "米聊是小米科技出品的一款免费即时通讯工具。");
        mylistList.add(map3);
        SimpleAdapter mysimAdapter=new SimpleAdapter(getContext(), mylistList, R.layout.layout_news_item_listview ,new String[]{"logo","content","title"},new int[]{R.id.f2_item_img_logo ,R.id.f2_item_tv_content ,R.id. f2_item_tv_title });
        ListView mylistview=rootview.findViewById(R.id.f2_lv );
        mylistview.setAdapter(mysimAdapter);
        return rootview;
    }
}
