package com.alex.androidjetpack.ui.view;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MyFrameLayout extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    private static final String TAG = "MyEvent";
    public MyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        Log.d(TAG,"MyFrameLayout init");
        setOnClickListener(this);
        setOnTouchListener(this);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG,"MyFrameLayout onInterceptTouchEvent..");


        //return super.onInterceptTouchEvent(ev);
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG,"MyFrameLayout dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"MyFrameLayout onTouchEvent" + event.getAction());
         //return super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                return false;
        }

        return  true;
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        Log.e(TAG,"MyFrameLayout onClick");
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // TODO Auto-generated method stub
        Log.e(TAG,"MyFrameLayout onTouch  " + event.getAction());
        return false;
    }
}