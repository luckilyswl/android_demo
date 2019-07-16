package com.example.zhou.zhendonghua;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivWang;
    private Button btnStart;
    private Button btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ivWang = findViewById(R.id.iv_wang);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivWang.setImageResource(R.drawable.anim);
                AnimationDrawable animationDrawable = (AnimationDrawable) ivWang.getDrawable();
                animationDrawable.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivWang.setImageResource(R.drawable.anim);
                AnimationDrawable animationDrawable = (AnimationDrawable) ivWang.getDrawable();
                animationDrawable.stop();
            }
        });
    }
}
