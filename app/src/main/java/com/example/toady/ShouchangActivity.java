package com.example.toady;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.toady.adapter.MyRvadapter;
import com.example.toady.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class ShouchangActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private Toolbar toolbar;
private List<NewsBean> beans=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouchang);
        recyclerView=findViewById(R.id.shoucehang_rv);
        recyclerView.setAdapter(new MyRvadapter(getApplicationContext(),beans));
        toolbar=findViewById(R.id.shouchang_toor);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SharedPreferences sharedPreferences=getSharedPreferences("dataa",MODE_PRIVATE);
        String title = sharedPreferences.getString("title","没有找到");
        String name = sharedPreferences.getString("name","没有找到");
        String img = sharedPreferences.getString("img",null);
        String url = sharedPreferences.getString("url","https://www.baidu.com");

        beans.add(new NewsBean(title,name,img,url));

    }
}
