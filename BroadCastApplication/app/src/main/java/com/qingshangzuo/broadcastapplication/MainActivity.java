package com.qingshangzuo.broadcastapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int MSG_SHOW_TIME = 1001;
    private MyReceiver receiver;
    private TextView txtTime;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHandler();
        initReceiver();

        txtTime = (TextView) findViewById(R.id.txt_time);


        // 多线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//
//                    handler.sendEmptyMessage(MSG_SHOW_TIME);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showTime();
                handler.postDelayed(this, 1000);
            }
        }, 1000);


    }

    private void initHandler() {

    }

    private void showTime(){
        SimpleDateFormat fomat =  new SimpleDateFormat ("yyyy年MM月dd日   HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String str = fomat.format(date);
        txtTime.setText(str);
    }

 /*   private void showTime2(){
        Time t = new Time();
        t.setToNow();
        String str = t.hour + ":" + t.minute ;
        txtTime.setText(str);
    }*/

    private void initReceiver() {
        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);
        filter.addAction("android.provier.Telephony.SMS_RECEIVED");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
//            Toast.makeText(context,"收到广播" + action , Toast.LENGTH_SHORT).show();
            Log.e("MainActivity", "收到广播" + action);

            if(action.equals(Intent.ACTION_TIME_TICK)){
//                showTime2();
            }
        }
    }
}


