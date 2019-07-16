package com.example.zhou.toumingsuofang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnAlpha;
    private Button btnScale;
    private ImageView ivPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation alpha = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        final Animation scale = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        ivPic = findViewById(R.id.iv_pic);

        btnAlpha = findViewById(R.id.btn_alpha);
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPic.startAnimation(alpha);
            }
        });

        btnScale = findViewById(R.id.btn_scale);
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPic.startAnimation(scale);
            }
        });
    }
}
