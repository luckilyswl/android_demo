package com.example.yls.demoa;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by yls on 2018/5/23.
 */

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "87230c7e27a536486ea5700af21813da");
    }
}
