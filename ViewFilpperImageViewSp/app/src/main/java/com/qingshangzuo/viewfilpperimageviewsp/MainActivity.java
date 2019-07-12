package com.qingshangzuo.viewfilpperimageviewsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private ViewFlipper myFlipper;
    private Button btnStart;
    private int downx;
    private int upx;
    private boolean hasShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasShow =  getFromSP();
        if(hasShow){
            Intent intent = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(intent);
            finish();
        }


        myFlipper = (ViewFlipper) findViewById(R.id.my_flipper);
//        myFlipper.startFlipping();

        btnStart = (Button) findViewById(R.id.btn_start);

        // 写完new之后 按CTRL+SHIFT+长长空格键
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                savtToSP();
                finish();
            }
        });

    }

    private boolean getFromSP() {
        SharedPreferences sp = getSharedPreferences("HASSHOW", Context.MODE_PRIVATE);
        int version = getVersioncode();
        return sp.getBoolean("HASSHOW"+version, false);
    }

    private void savtToSP() {
        SharedPreferences sp = getSharedPreferences("HASSHOW", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        int version = getVersioncode();
        editor.putBoolean("HASSHOW"+ version, true);
        editor.commit();
    }

    private int getVersioncode() {
        PackageInfo info = null;
        int version = 0;
        try {
            info = getPackageManager().getPackageInfo(this.getPackageName(), 0);
            version = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                downx = (int) event.getX();
                Log.e(TAG, "ACTION_DOWN x = " + event.getX() + " y = " + event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "ACTION_MOVE x = " + event.getX() + " y = " + event.getY());
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "ACTION_UP x = " + event.getX() + " y = " + event.getY());
                upx = (int) event.getX();
                if(upx - downx > 100)
                {
                    // 向右滑 显示上一张
                    myFlipper.showPrevious();
                }
                if(downx - upx> 100)
                {
                    // 向左滑 显示一张
                    myFlipper.showNext();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}

