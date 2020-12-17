package com.alex.androidjetpack.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alex.androidjetpack.R;
import com.alex.androidjetpack.ui.maplinedemo.AnimatorPath.AnimatorPath;
import com.alex.androidjetpack.ui.ndk.JniPerson;
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
                Toast.makeText(NDKDemoActivity.this, "C函数返回结果：" + stringFromJNI(), Toast.LENGTH_LONG).show();
            }
        });


        findViewById(R.id.btn_call_c_obj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JniPerson mJniPerson = new JniPerson();
                mJniPerson.setAge(800);
                Toast.makeText(NDKDemoActivity.this, "C对象指针：" + mJniPerson.getNativePerson() + " 年龄属性：" + mJniPerson.getAge(), Toast.LENGTH_LONG).show();
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