package com.qingshangzuo.appsapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final int MSG_RESULT = 1001;
    private Button btnJisuan;
    private TextView tvResult;
    private Handler handler;
    private Button btnJump;
    private Button btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHandler();

        btnJisuan = (Button) findViewById(R.id.btn_jisuan);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnJump = (Button) findViewById(R.id.btn_jump);

        //BROADCAST_ANOTHER
        btnTest = (Button) findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setAction("BROADCAST_ANOTHER");
                intent.putExtra("NAME","fengqiang");
                sendBroadcast(intent);
            }
        });


        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btnJisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*  long  start = System.currentTimeMillis();                 double num = 0;
                for(int i=0; i<= Integer.MAX_VALUE; i++){
                    num += i*i;
                }                  long  end = System.currentTimeMillis();
                tvResult.setText(String.valueOf(num) + "用时 " + (end - start) +"毫秒");*/
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        double num = 0;
                        for(int i=0; i<= 1000000000; i++){
                            num += i*i;
                        }
                        Message msg = Message.obtain();
                        msg.what = MSG_RESULT;
                        msg.obj = num;
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });
    }
    private void initHandler() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_RESULT){
                    double result = (double) msg.obj;
                    tvResult.setText(String.valueOf(result));
                    return true;
                }
                return false;
            }
        });


    }
}

