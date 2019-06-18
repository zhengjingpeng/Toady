package com.example.toady;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.toady.bean.CaiBean;
import com.example.toady.bean.Data;

import java.io.Serializable;
import java.util.List;

public class CaiActivity extends AppCompatActivity {
private TextView tv_content;
    private Toolbar toolbar;
    private RecyclerView rv_yongliao,rv_zuofa;
    private CaiBean.ResultBean.ListBean listBean;
    private ImageView cai_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai);
        initView();
        System.out.println(Data.hashMap);
        listBean= (CaiBean.ResultBean.ListBean)( Data.hashMap.get("bean"));
        Data.hashMap.remove("bean");
       tv_content.setText(listBean.getContent());
        Glide
                .with(getApplicationContext())
                .load(listBean.getPic())
                .into(cai_iv);
       toolbar.setTitle(listBean.getName());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
       rv_yongliao.setLayoutManager(linearLayoutManager);
       rv_yongliao.setAdapter(new YongliaoAd());
       rv_zuofa.setLayoutManager(linearLayoutManager1);
       rv_zuofa.setAdapter(new ZuofaAd() );

    }

    private void initView() {
        toolbar=findViewById(R.id.cai_toor);
        tv_content=findViewById(R.id.cai_content);
        rv_yongliao=findViewById(R.id.yongliao_rv);
        rv_zuofa=findViewById(R.id.zuofa_rv);
        cai_iv=findViewById(R.id.cai_iv);
    }
    class ZuofaAd extends RecyclerView.Adapter<ZuofaAd.viewholder>{

        @NonNull
        @Override
        public ZuofaAd.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_zuofa,null);
            return new viewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ZuofaAd.viewholder viewholder, int i) {

                viewholder.tv_zuofa.setText(listBean.getProcess().get(i).getPcontent());
                Glide
                    .with(getApplicationContext())
                    .load(listBean.getProcess().get(i).getPic())
                    .into(viewholder.iv_pic);
        }

        @Override
        public int getItemCount() {
            return listBean.getProcess().size();
        }
        class viewholder extends RecyclerView.ViewHolder{
                private TextView tv_zuofa;
                private ImageView iv_pic;
            public viewholder(@NonNull View itemView) {
                super(itemView);
                tv_zuofa=itemView.findViewById(R.id.tv_zuofa);
                iv_pic=itemView.findViewById(R.id.iv_pic);
            }
        }
    }
    class YongliaoAd extends RecyclerView.Adapter<YongliaoAd.viewholder>{

        @NonNull
        @Override
        public YongliaoAd.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_yongliao,null);
            return new viewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull YongliaoAd.viewholder viewholder, int i) {
            viewholder.tv_amane.setText(listBean.getMaterial().get(i).getMname());
            viewholder.tv_amout.setText(listBean.getMaterial().get(i).getAmount());
        }

        @Override
        public int getItemCount() {
            return listBean.getMaterial().size();
        }
        class viewholder extends RecyclerView.ViewHolder{
private TextView tv_amane,tv_amout;
            public viewholder(@NonNull View itemView) {
                super(itemView);
                tv_amane=itemView.findViewById(R.id.mname);
                tv_amout=itemView.findViewById(R.id.amount);
            }
        }
    }
}
