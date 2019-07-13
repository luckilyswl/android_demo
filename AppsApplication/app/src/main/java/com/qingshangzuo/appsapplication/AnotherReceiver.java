package com.qingshangzuo.appsapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"AnotherReceiver收到了广播 名字是" + intent.getStringExtra("NAME"), Toast.LENGTH_SHORT).show();
    }
}
