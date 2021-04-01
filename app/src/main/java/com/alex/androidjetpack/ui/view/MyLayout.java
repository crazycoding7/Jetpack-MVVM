package com.alex.androidjetpack.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

// requestDisallInterceptRouchEvent(boolean disallowIntercept) 禁止父类拦截action！！！
public class MyLayout extends LinearLayout {
    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("TAG", "You onInterceptTouchEvent layout = " + ev.getAction());

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return false;
            case MotionEvent.ACTION_MOVE:   //表示父类需要
                return true;
            case MotionEvent.ACTION_UP:
                return true;
            default:
                break;
        }
        return true;    //如果设置拦截，除了down,其他都是父类处理
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("TAG", "You down layout");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("TAG", "You up layout");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("TAG", "You move layout");
        }
        return true;
    }
}