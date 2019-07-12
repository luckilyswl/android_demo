package com.qingshangzuo.intentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tvName = (TextView) findViewById(R.id.tvName);
        String name = getIntent().getStringExtra("NAME");
        boolean isBoy = getIntent().getBooleanExtra("ISBOY", true);

        if(isBoy){
            tvName.setText("我是"+ name + "帅哥");
        }else{
            tvName.setText("我是"+ name + "美女");
        }


    }
}
