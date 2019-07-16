package com.qingshangzuo.newstoutiao;

import android.app.Application;

import cn.bmob.v3.Bmob;

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "f7b5a03549d57f20c7f0954933125803");
    }
}
