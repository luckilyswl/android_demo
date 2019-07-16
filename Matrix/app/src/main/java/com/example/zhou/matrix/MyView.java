package com.example.zhou.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhou on 2018/3/27.
 */

public class MyView extends View {
    private Bitmap bitmap;
    private Paint paint = new Paint();

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /* 分辨率不同 */
        Matrix matrix = new Matrix();

//        canvas.drawBitmap(bitmap,matrix,paint);

//        matrix.postRotate(90,300,300);
//        matrix.postTranslate(200,0);
//        canvas.drawBitmap(bitmap,matrix,paint);
//
//        matrix.postRotate(90,300,300);
//        matrix.postTranslate(0,200);
//        canvas.drawBitmap(bitmap,matrix,paint);
//
//        matrix.postRotate(90,300,300);
//        matrix.postTranslate(-200,0);
//        canvas.drawBitmap(bitmap,matrix,paint);


        matrix.setScale(-1,1);
        matrix.postTranslate(300,0);
        canvas.drawBitmap(bitmap,matrix,paint);

        matrix.setScale(1,1);
        matrix.postTranslate(300,0);
        canvas.drawBitmap(bitmap,matrix,paint);

        matrix.setScale(1,-1);
        matrix.postTranslate(300,600);
        canvas.drawBitmap(bitmap,matrix,paint);

        matrix.setScale(-1,-1);
        matrix.postTranslate(300,600);
        canvas.drawBitmap(bitmap,matrix,paint);

    }
}
