package com.qingshangzuo.appsapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button btnJisuan;
    private TextView tvResult;
    private MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initReceiver();

        btnJisuan = (Button) findViewById(R.id.btn_jisuan);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnJisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        double num = 0;
                        for(int i=0; i<= 1000000; i++){
                            num += i*i;
                        }
                        Intent intent = new Intent();
                        intent.setAction("BROADCAST_RESULT");
                        intent.putExtra("RESULT", num);
                        sendBroadcast(intent);
                    }
                }).start();
            }
        });
    }
    // 代码中注册  称为  动态注册
    private void initReceiver() {
        receiver =new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("BROADCAST_RESULT");
        registerReceiver(receiver,filter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("BROADCAST_RESULT")){
                double num = intent.getDoubleExtra("RESULT",-1);
                tvResult.setText(String.valueOf(num));
            }
        }
    }
}
