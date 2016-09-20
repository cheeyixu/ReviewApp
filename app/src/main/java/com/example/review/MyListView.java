package com.example.review;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by jesmond on 20/9/2016.
 */
public class MyListView extends ListView {
    private android.view.ViewGroup.LayoutParams params;
    private int old_count = 0;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getCount() != old_count) {
            old_count = getCount();
            params = getLayoutParams();
            params.height = getCount() * (old_count > 0 ? getChildAt(0).getHeight() : 0);
            setLayoutParams(params);
        }

        super.onDraw(canvas);
    }
//    @Override
//    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
//                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
//        ViewGroup.LayoutParams params = getLayoutParams();
//        params.height = getMeasuredHeight();
//    }

}