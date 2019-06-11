package com.example.toady.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.toady.LoginActivity;
import com.example.toady.MainActivity;
import com.example.toady.R;
import com.example.toady.ShouchangActivity;
import com.example.toady.Utils.OtherUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MeFragment extends BaseFragment {
private ImageView imageView,imageView_night;
private CircleImageView circleImageView;
private TextView textView;

    @Override
    protected void getData() {

    }

    @Override

    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        View rootview=inflater.inflate(R.layout.fragment_4,container,false);

            imageView=rootview.findViewById(R.id.me_shouchang);
            imageView_night=rootview.findViewById(R.id.iv_night);
            imageView_night.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                    ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO ?
                            AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                    ((AppCompatActivity)getActivity()).recreate();

                /*    Intent intent=new Intent(getActivity().getApplicationContext(),MainActivity.class);
                    startActivity(intent);*/


                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(), ShouchangActivity.class);
                    startActivity(intent);
                }
            });
            circleImageView=rootview.findViewById(R.id.circle);
            circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                    startActivityForResult(intent,1);
                }
            });
            textView=rootview.findViewById(R.id.title);
        return rootview;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            String name = data.getStringExtra("name");
            textView.setText(name);
        }
    }
}
