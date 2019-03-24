package com.example.toady.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.toady.MainActivity;
import com.example.toady.R;

import java.util.List;

public class MeFragment extends BaseFragment {

    public String[] province;
    private String[][] city;
    private Spinner sp_province,sp_city;
    @Override
    protected void getData() {

    }

    @Override

    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        View rootview=inflater.inflate(R.layout.fragment_4,container,false);
       province=new String[]{"北京","上海","天津","广东"};
        city=new String[][]{{"东城区","朝阳区","丰台区","顺义区"},{"东城区","东城区","东城区","东城区"},{"东城区","东城区","东城区","东城区"},{"佛山","广州","汕头","肇庆"}};
        sp_province=rootview.findViewById(R.id.sp_province);
        sp_city=rootview.findViewById(R.id.sp_city);
        ArrayAdapter<String> arrayAdapter_province=new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item, province);
        sp_province.setAdapter(arrayAdapter_province);
        ArrayAdapter<String> arrayAdapter_city=new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,city[0]);
        sp_city.setAdapter(arrayAdapter_city);
      /*  sp_province.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                ArrayAdapter<String> arrayAdapter_city1=new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,city[i]);
                sp_city.setAdapter(arrayAdapter_city1);
            }
        });*/
        return rootview;
    }
}
