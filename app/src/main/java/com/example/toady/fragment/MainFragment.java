package com.example.toady.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.toady.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainFragment extends BaseFragment  {

    @Override
    protected void getData() {

    }

    @Override
    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        View rootview=inflater.inflate(R.layout.fragment_1,container,false);
        ArrayList<Map<String,Object>> mylist=new ArrayList<Map<String,Object>>();
        Map<String, Object> map1=new HashMap<String,Object>();
        map1.put("logo",R.drawable.weixin);
        map1.put("title","微信");
        mylist.add(map1);

        Map<String, Object> map2=new HashMap<String,Object>();
        map2.put("logo",R.drawable.yixin);
        map2.put("title","易信");
        mylist.add(map2);

        Map<String, Object> map3=new HashMap<String,Object>();
        map3.put("logo",R.drawable.miliao);
        map3.put("title","米聊");
        mylist.add(map3);
        Map<String, Object> map4=new HashMap<String,Object>();
        map4.put("logo",R.drawable.iv_icon_1);
        map4.put("title","UC");
        mylist.add(map4);
        Map<String, Object> map5=new HashMap<String,Object>();
        map5.put("logo",R.drawable.iv_icon_2);
        map5.put("title","阅读");
        mylist.add(map5);
        Map<String, Object> map6=new HashMap<String,Object>();
        map6.put("logo",R.drawable.iv_icon_3);
        map6.put("title","路灯");
        mylist.add(map6);
        SimpleAdapter sa=new SimpleAdapter(getContext(),mylist,R.layout.layout_news_item,
                new String[]{"logo","title"},new int[]{R.id.img_logo,R.id.tv_title}
        );
        GridView gv=rootview.findViewById(R.id.gv);
        gv.setAdapter(sa);
        return rootview;
    }
}
