package com.example.yls.demoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv_text);

        findViewById(R.id.btn_star1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json="{name:\"Alex\",age:18,isMan:true}";
                Gson gson=new Gson();
                User user=gson.fromJson(json,User.class);
                textView.setText(user.toString());
            }
        });

        findViewById(R.id.btn_star2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str="";
                String json="[{name:\"Alex\",age:18,isMan:true,sex:\"男\"}," +
                            "{name:\"Amay\",age:22,isMan:false,sex:\"女\"}," +
                            "{name:\"Json\",age:18,isMan:true,sex:\"男\"}]";
                Gson gson=new Gson();
                User[] users=gson.fromJson(json,User[].class);
                for (int i=0;i<users.length;i++){
                    str=str+users[i].toString()+"\n";
                }
                textView.setText(str);
            }
        });

        findViewById(R.id.btn_star3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
