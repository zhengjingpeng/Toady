package com.example.toady.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.toady.R;

public class DDFagment extends BaseFragment {
    private int[] imgDate;
    @Override
    protected void getData() {

    }

    @Override
    protected void setSubListen() {

    }

    @Override
    protected View getSubiew(LayoutInflater inflater, ViewGroup container) {
        View rootview = inflater.inflate(R.layout.fragment_3, container, false);
        imgDate=new int[]{R.drawable.mm1,R.drawable.mm2,R.drawable.mm3,R.drawable.mm4,R.drawable.mm5};

        MyAdapter myAdapter=new MyAdapter();
        Gallery gallery=rootview.findViewById(R.id.gl_pic);
        gallery.setAdapter(myAdapter);
        return rootview;
    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imgDate.length;
        }

        @Override
        public Object getItem(int i) {
            return imgDate[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView myview=new ImageView(getContext());
            myview.setImageResource(imgDate[i]);

            return myview;
        }
    }
}
