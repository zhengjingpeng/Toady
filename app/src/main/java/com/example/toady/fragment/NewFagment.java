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

        return rootview;
    }
}
