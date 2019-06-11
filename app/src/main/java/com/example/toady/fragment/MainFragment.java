package com.example.toady.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.toady.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends BaseFragment  {
    private TabLayout tabLayout;
    private List<Fragment> fragments;
    private ViewPager viewPager;

    @Override
    protected void getData() {

    }

    @Override
    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        View rootview=inflater.inflate(R.layout.fragment_1,container,false);
        tabLayout=rootview.findViewById(R.id.f1_tab);
        tabLayout.addTab(tabLayout.newTab().setText("头条"));
        tabLayout.addTab(tabLayout.newTab().setText("社会"));
        tabLayout.addTab(tabLayout.newTab().setText("国际"));
        tabLayout.addTab(tabLayout.newTab().setText("娱乐"));
        tabLayout.addTab(tabLayout.newTab().setText("体育"));
        tabLayout.addTab(tabLayout.newTab().setText("军事"));
        tabLayout.addTab(tabLayout.newTab().setText("科技"));
        tabLayout.addTab(tabLayout.newTab().setText("财经"));
        tabLayout.addTab(tabLayout.newTab().setText("时尚"));
        fragments=new ArrayList<Fragment>();
        fragments.add(new f1());
        fragments.add(new f2());
        fragments.add(new f3());
        fragments.add(new f4());
        fragments.add(new f5());
        fragments.add(new f6());
        fragments.add(new f7());
        fragments.add(new f8());
        fragments.add(new f9());
        Myadapter myadapter=new Myadapter(getFragmentManager());
        viewPager= rootview.findViewById(R.id.f1_vp);
        viewPager.setAdapter(myadapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i <tabLayout.getTabCount() ; i++) {
                    if(tab==tabLayout.getTabAt(i)){
                        viewPager.setCurrentItem(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return rootview;
    }
class Myadapter extends FragmentPagerAdapter{

    public Myadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

}
