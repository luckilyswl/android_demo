package com.example.yls.demoa;

import android.app.Application;
import android.util.Log;

import cn.bmob.v3.Bmob;

/**
 * Created by yls on 2018/5/3.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 进行应用的初始化
        Log.e("MyApplication", "onCreate");
        Bmob.initialize(MyApplication.this,"87230c7e27a536486ea5700af21813da");

    }
}
