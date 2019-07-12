package com.qingshangzuo.intentapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartB;
    private Button btnEat;
    private Button btnStartWeb;
    private Button btnStartCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("我是新标题");

        btnStartB = findViewById(R.id.btnStartB);
        btnEat =  findViewById(R.id.btnEat);
        btnStartWeb = findViewById(R.id.btnStartWeb);
        btnStartCall = findViewById(R.id.btnStartDial);

        btnStartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式Intent
                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                intent.putExtra("NAME", "青青");
                intent.putExtra("ISBOY", false);
                startActivity(intent);
            }
        });

        // 隐式Intent
        btnStartWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        btnStartCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        btnEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("I_WANT_EAT");
                intent.addCategory("JIPAFAN");
                startActivity(intent);
            }
        });

    }



}

