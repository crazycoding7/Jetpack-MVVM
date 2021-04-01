package com.alex.androidjetpack.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alex.androidjetpack.R;
import com.alex.androidjetpack.app.base.BaseActivity;

public class TestUIEventActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_inter_parent);

        //((TextView)findViewById(R.id.tv_scroll_me)).setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyEvent","TestUIEventActivity onTouchEvent().." + event.getAction());


        return super.onTouchEvent(event);
    }
}
