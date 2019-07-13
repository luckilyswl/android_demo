package com.qingshangzuo.bmobapplication;

import android.app.Application;
import android.util.Log;

import cn.bmob.v3.Bmob;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyApplication","onCreate");
        Bmob.initialize(MyApplication.this,"f7b5a03549d57f20c7f0954933125803");
    }
}
