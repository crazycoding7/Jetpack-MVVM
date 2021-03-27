package com.alex.androidjetpack.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 自定义小球，跟随手指移动(结合WindowManager.addView实现拖拽浮窗&绘制贝塞尔曲线实现两个圆的效果。)
 */
public class MyDotView extends View {
    private static final String TAG = MyDotView.class.getSimpleName();
    private Paint paint = new Paint();
    private int x = 100;
    private int y = 100;
    private int radius = 100;

    public MyDotView(Context context) {
        super(context);
    }

    public MyDotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyDotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                x = (int) event.getX();
                y = (int) event.getY();

                Log.e(TAG, "onTouchEvent: " + event.getAction() + " " + event.getX() + " " + event.getY()  + getRootView());
                break;
        }





        postInvalidate();


        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawCircle(x,y,radius,paint);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int height = 200;
//        int width = 200;
//        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
//        final int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
//        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
//        final int heightSpecSize = MeasureSpec.getMode(heightMeasureSpec);
//        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
//            setMeasuredDimension(width,height);
//        }else if (widthSpecMode == MeasureSpec.AT_MOST) {
//            setMeasuredDimension(width,heightSpecSize);
//        }else if (heightSpecMode == MeasureSpec.AT_MOST) {
//            setMeasuredDimension(widthSpecSize,height);
//        }
//    }
}
