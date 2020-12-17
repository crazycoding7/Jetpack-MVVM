package com.alex.androidjetpack.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alex.androidjetpack.R;
import com.alex.androidjetpack.ui.maplinedemo.AnimatorPath.AnimatorPath;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NDKDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fab;
    private AnimatorPath path;//声明动画集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk);

        findViewById(R.id.btn_call_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NDKDemoActivity.this, "结果：" + stringFromJNI(), Toast.LENGTH_LONG).show();
            }
        });
    }

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

    // 快捷键自动创建jni函数
//    public native String testTwo();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:

                break;
        }
    }
}