package com.alex.androidjetpack.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends androidx.appcompat.widget.AppCompatButton {
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                Log.e("TAG", "You down button");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("TAG", "You up button");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("TAG", "You move button");
        }
        return true;
    }
}