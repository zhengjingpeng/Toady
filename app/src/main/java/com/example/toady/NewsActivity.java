package com.example.toady;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.toady.bean.NewsBean;


public class NewsActivity extends AppCompatActivity {
private WebView webView;
private NewsBean bean;
private String url;
private Toolbar toolbar;
private String title,name,img;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        webView=findViewById(R.id.webview);
        imageView=findViewById(R.id.news_shouchang);
        bean=(NewsBean) getIntent().getSerializableExtra("bean");
        url=bean.url;
        title=bean.title;
        name=bean.name;
        img=bean.image;
        toolbar=findViewById(R.id.news_toobar);
        toolbar.setTitle(name);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("dataa",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("url",url);
                editor.putString("title",title);
                editor.putString("name",name);
                editor.putString("img",img);
                editor.commit();
                Toast.makeText(NewsActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
        initWeb();

    }

    private void initWeb() {
        webView.loadUrl(url);
        WebSettings mWebSettings = webView.getSettings();
        mWebSettings.setSupportZoom(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("GBK");//设置解码格式
        mWebSettings.setLoadsImagesAutomatically(true);
        mWebSettings.setJavaScriptEnabled(true);//支持js 特效
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}
