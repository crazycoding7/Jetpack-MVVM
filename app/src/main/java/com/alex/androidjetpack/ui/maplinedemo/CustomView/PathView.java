package com.alex.androidjetpack.ui.maplinedemo.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * 时 间: 2016/11/8 0008
 * 作 者: 郑亮
 * Q  Q : 1023007219
 */

public class PathView extends View {

    private Paint paint;

    ArrayList<int[]> points = new ArrayList<>();

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

        points.add(new int[]{430, 230});
        points.add(new int[]{460, 265});
        points.add(new int[]{480, 280});
        points.add(new int[]{490, 285});
        points.add(new int[]{500, 300});
        points.add(new int[]{495, 315});
        points.add(new int[]{492, 330});
        points.add(new int[]{470, 370});
        points.add(new int[]{475, 380});
        points.add(new int[]{480, 430});

        points.add(new int[]{500, 460});

        points.add(new int[]{520, 485});
//        points.add(new int[]{400, 580});
//        points.add(new int[]{460, 680});
    }

    private void initView() {
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //防抖动
        paint.setDither(true);
        //设置画笔未实心
        paint.setStyle(Paint.Style.STROKE);
        //设置颜色
        paint.setColor(Color.GREEN);
        //设置画笔宽度
        paint.setStrokeWidth(10);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(60,60);

        int[] pre = null;
        for(int i = 0 ;i < points.size();i++){
            int[] point = points.get(i);
            if(i == 0){
                path.moveTo(point[0],point[1]);
                pre = point;
                continue;
            }

            path.lineTo(point[0],point[1]);

//            path.quadTo((pre[0]+point[0])/2, point[1], point[0],point[1]);

            pre = point;
        }

//        path.lineTo(460,460); // 760 860
//
//        path.cubicTo(610,160,610,860,760,860);



        //path.lineTo(440,490);
        //path.lineTo(450,530);
        //path.lineTo(400,580);
        //path.lineTo(460,680);




//        path.lineTo(460,460);
//        path.lineTo(460,460);
//        path.lineTo(460,460);
//        path.lineTo(460,460);
//        boolean xChange = false;
//        for (int i =20;i< 1000;i=i+20){
//            int x = xChange? 460:600;
//            xChange = !xChange;
//
//            path.lineTo(x,460 + i*2);
//            //path.quadTo(660, 400+i*2, x,460 + i*2);
//
//        }

       // path.quadTo(660, 260, 860, 460); //订单
//        path.cubicTo(160,660,960,1060,260,1260);
        canvas.drawPath(path,paint);
    }
}
