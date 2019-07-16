package com.example.zhou.wifi;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivWifi;
    private Button btnStart;
    private Button btnStop;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivWifi = findViewById(R.id.iv_wifi);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivWifi.setImageResource(R.drawable.anim);
                AnimationDrawable animationDrawable = (AnimationDrawable) ivWifi.getDrawable();
                animationDrawable.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivWifi.setImageResource(R.drawable.anim);
                AnimationDrawable animationDrawable = (AnimationDrawable) ivWifi.getDrawable();
                animationDrawable.stop();
            }
        });
    }
}
