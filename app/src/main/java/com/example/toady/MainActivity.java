package com.example.toady;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.toady.Utils.Constans;

import com.example.toady.adapter.VpAdapt;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {


    /**
     * 首页
     */
    private RadioButton mMainRbtnHome;
    /**
     * 新闻
     */
    private RadioButton mMainRbtnNews;
    /**
     * 图片
     */
    private RadioButton mDd;
    /**
     * 我
     */
    private RadioButton mMainRbtnMe;
    private RadioGroup mMainGp;
    private ViewPager mvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        FragmentManager supportFragmentManager = this.getSupportFragmentManager();
        initView();
        initListen();

        mMainRbtnHome.setChecked(true);
        mMainGp.setOnCheckedChangeListener(this);
        VpAdapt vpAdapt=new VpAdapt(supportFragmentManager);
        mvp.setAdapter(vpAdapt);


    }

    private void initListen() {
        mvp.addOnPageChangeListener(this);
    }

    private void initView() {
        mMainRbtnHome = (RadioButton) findViewById(R.id.main_rbtn_home);
        mMainRbtnNews = (RadioButton) findViewById(R.id.main_rbtn_news);
        mDd = (RadioButton) findViewById(R.id.dd);
        mMainRbtnMe = (RadioButton) findViewById(R.id.main_rbtn_me);
        mMainGp = (RadioGroup) findViewById(R.id.main_gp);
        mvp=findViewById(R.id.main_vp);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_rbtn_home:
                mvp.setCurrentItem(Constans.PAGER_HOMT);
                break;
            case R.id.main_rbtn_news:
                mvp.setCurrentItem(Constans.PAGER_NEW);
                break;
            case R.id.dd:
                mvp.setCurrentItem(Constans.PAGER_DD);
                break;
            case R.id.main_rbtn_me:
                mvp.setCurrentItem(Constans.PAGER_ME);
                break;
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case Constans.PAGER_HOMT:
                mMainGp.check(R.id.main_rbtn_home);
                break;
            case Constans.PAGER_NEW:
                mMainGp.check(R.id.main_rbtn_news);
                break;
            case Constans.PAGER_DD:
                mMainGp.check(R.id.dd);
                break;
            case Constans.PAGER_ME:
                mMainGp.check(R.id.main_rbtn_me);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
