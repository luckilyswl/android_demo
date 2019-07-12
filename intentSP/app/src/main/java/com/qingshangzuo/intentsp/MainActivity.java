package com.qingshangzuo.intentsp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private TextView textResult;
    private int REQUSET_CODEB = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = (TextView) findViewById(R.id.textResult);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
//                startActivity(intent);

                // 如果要获取数据
                startActivityForResult(intent, REQUSET_CODEB);
            }
        });

        // 读取sp
        readFromSP();
    }

    private void readFromSP() {
        SharedPreferences sp = getApplicationContext().getSharedPreferences("PERSON", getApplicationContext().MODE_PRIVATE);
        String name = sp.getString("NAME", "noname");
        int age = sp.getInt("AGE", 0);
        boolean isBoy = sp.getBoolean("ISBOY", true);

        if(isBoy){
            textResult.setText("姓名：" + name +"  年龄：" + age + "  帅哥");
        }else {
            textResult.setText("姓名：" + name +"  年龄：" + age + "  美女");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MainActivity", "requestCode = " + requestCode + "  resultCode = " + resultCode);

        String name = data.getStringExtra("NAME");
        int age = data.getIntExtra("AGE", 0);
        boolean isBoy = data.getBooleanExtra("ISBOY", true);

        if(isBoy){
            textResult.setText("姓名：" + name +"  年龄：" + age + "  帅哥");
        }else {
            textResult.setText("姓名：" + name +"  年龄：" + age + "  美女");
        }

        saveToSP(name, age, isBoy);
    }

    private void saveToSP(String name, int age, boolean isBoy) {
        // 保存到SharedPreference
        SharedPreferences sp = getApplicationContext().getSharedPreferences("PERSON", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("NAME", name);
        editor.putInt("AGE", age);
        editor.putBoolean("ISBOY", isBoy);
        editor.commit();
    }
}

