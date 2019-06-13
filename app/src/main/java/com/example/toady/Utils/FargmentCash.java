package com.example.toady.Utils;

import com.example.toady.fragment.BaseFragment;
import com.example.toady.fragment.WeatherFagment;
import com.example.toady.fragment.MainFragment;
import com.example.toady.fragment.MeFragment;
import com.example.toady.fragment.NewFagment;

import java.util.HashMap;
import java.util.Map;

public class FargmentCash {
    public static Map<Integer, BaseFragment> sCash=new HashMap<>();
    public static BaseFragment getFragmentById(int position){
        BaseFragment baseFragment=sCash.get(position);
        if(baseFragment!=null){
            return baseFragment;
        }
        switch (position){
            case Constans.PAGER_HOMT:
                baseFragment=new MainFragment();
                break;
            case Constans.PAGER_NEW:
                baseFragment=new NewFagment();
                break;
            case Constans.PAGER_DD:
                baseFragment=new WeatherFagment();
                break;
            case Constans.PAGER_ME:
                baseFragment=new MeFragment();
                break;
        }
        sCash.put(position,baseFragment);
        return baseFragment;
    }
}
