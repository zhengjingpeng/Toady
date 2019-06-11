package com.example.toady.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.toady.Utils.Constans;
import com.example.toady.Utils.FargmentCash;

public class VpAdapt extends FragmentPagerAdapter {

    public VpAdapt(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FargmentCash.getFragmentById(position);
    }

    @Override
    public int getCount() {
        return Constans.TAB_COUNT;
    }
}
