package com.example.toady.Utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.toady.R;

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        Paint paint = new Paint();
        paint.setStrokeWidth(20);
        paint.setColor(Color.WHITE);

        // 获得RecyclerView中总条目数量
        int childCount = parent.getChildCount();
        //遍历一下
        for (int i = 0; i < childCount; i++) {
            if (i == 0) {
                //如果是第一个条目，那么我们就不画边框了
                continue;
            }

            // 获得子View，也就是一个条目的View，准备给他画上边框
            View childView = parent.getChildAt(i);
            //先获得子View的长宽，以及在屏幕上的位置，方便我们得到边框的具体坐标
            float x = childView.getX();
            float y = childView.getY();
            int width = childView.getWidth();
            int height = childView.getHeight();
            //根据这些点画条目的四周的线
            c.drawLine(x, y, x + width, y, paint);
            c.drawLine(x, y, x, y + height, paint);
            c.drawLine(x + width, y, x + width, y + height, paint);
            c.drawLine(x, y + height, x + width, y + height, paint);
        }
        super.onDraw(c, parent, state);
    }
}
