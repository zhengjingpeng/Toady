package com.example.toady;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.toady.Utils.Constans;
import com.example.toady.Utils.FargmentCash;

class VpAdapt extends FragmentPagerAdapter {

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
