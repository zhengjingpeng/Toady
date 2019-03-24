package com.example.toady.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public  abstract class BaseFragment extends Fragment {
private View rootview=null;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        rootview=getSubiew(inflater,container);
        setSubListen();
        getData();
        return rootview;
    }

    protected abstract void getData();

    protected abstract void setSubListen();

    protected abstract View getSubiew(LayoutInflater inflater, ViewGroup container) ;

    
}

