package com.qingshangzuo.intentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        setTitle("第一饭堂");
    }
}
