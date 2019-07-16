package com.example.win10.androidshizhong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by win 10 on 2018/3/29.
 */

public class MyView extends View {

    private Paint paint = new Paint();
    private  float hradius = 60;
    private  float mradius = 70;
    private  float sradius = 80;
    private  float hour;
    private  int minute;
    private int second;
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        Log.e("MyView","result ="+ Math.sin(30 / 180 * Math.PI));
        initPaint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    postInvalidate();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        getNowTime();
    }

    public void getNowTime() {
        android.text.format.Time time= new android.text.format.Time();
        time.setToNow();
        int h = time.hour;
        minute = time.minute;
        second = time.second;
        hour = h+minute*1.0f/60;
    }


    private void initPaint() {
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint.setStrokeWidth(7);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.CYAN);
        canvas.drawCircle(200,200,100,paint);

        float x = (float) (200+hradius * (Math.sin(hour*30.0 / 180 * Math.PI)));
        float y = (float) (200-hradius * (1- Math.cos(hour*30.0 /180*Math.PI)));
        paint.setColor(Color.BLACK);
        canvas.drawLine(200,200,x,y,paint);

        float mx = (float) (200+mradius * (Math.sin(minute*60.0 / 180 * Math.PI)));
        float my = (float) (200-mradius * (1- Math.cos(minute*60.0 /180*Math.PI)));
        paint.setColor(Color.BLUE);
        canvas.drawLine(200,200,mx,my,paint);



        float sx = (float) (200+sradius * (Math.sin(second*6.0 / 180 * Math.PI)));
        float sy = (float) (200-sradius * (1- Math.cos(second*6.0 /180*Math.PI)));
        paint.setColor(Color.RED);
        canvas.drawLine(200,200,sx,sy,paint);


        super.onDraw(canvas);
    }


}
