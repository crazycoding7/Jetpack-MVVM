package com.alex.androidjetpack.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MyImageView extends androidx.appcompat.widget.AppCompatImageView implements View.OnClickListener, View.OnTouchListener {
    private static final String TAG = "MyEvent";
    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        Log.d(TAG,"===MyImageView init");
        setOnClickListener(this);
//        setClickable(true);
        setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG,"===MyImageView dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"===MyImageView onTouchEvent "  + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View arg0, MotionEvent arg1) {
        // TODO Auto-generated method stub
        Log.e(TAG,"===MyImageView onTouch " + arg1.getAction());
        return false;
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        Log.d(TAG,"===MyImageView onClick");
    }

}