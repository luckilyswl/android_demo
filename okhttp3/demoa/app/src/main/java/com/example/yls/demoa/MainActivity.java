package com.example.yls.demoa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final int GET_WEB_SUCCESS = 1001;
    private static final int GET_IMG_SUCCESS = 1002;
    private Button btnStart;
    private TextView tvResult;
    private Handler handler;
    private ImageView ivResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHandler();

        tvResult = findViewById(R.id.tv_result);
        btnStart = findViewById(R.id.btn_start);
        ivResult = findViewById(R.id.iv_result);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getWebUseOkHttp();
//                getWebUseOkHttpPost();
                downLoadImage();
            }
        });
    }

    private void downLoadImage() {

        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://p2.so.qhimgs1.com/bdr/_240_/t01fc8959344bc0353e.jpg";
        Request request = new Request.Builder().url(url).build();
        okhttp3.Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.e("MainActivity",e.toString());
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {

                InputStream inputStream = response.body().byteStream();
                //下面5行是显示在页面上的
                /*Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Message message = Message.obtain();
                message.what = GET_IMG_SUCCESS;
                message.obj = bitmap;
                handler.sendMessage(message);*/

                //保存到本地
                String filePath = getFilesDir().getAbsolutePath() + File.separator + "down.jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                byte[] buffer = new byte[2048];
                int len = 0;
                while ((len = inputStream.read(buffer)) != -1){
                    fileOutputStream.write(buffer,0,len);
                }

                fileOutputStream.flush();
                Log.e("MainActivity","save end");
            }
        });
    }

    private void getWebUseOkHttpPost() {

        String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().
                add("mobileCode","13671572654")
                .add("userID","").build();

        final Request request = new Request.Builder().url(url).post(requestBody).build();
        okhttp3.Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.e("MainActivity",e.toString());
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {

                Message message = Message.obtain();
                message.what = GET_WEB_SUCCESS;
                message.obj = response.body().string();
                handler.sendMessage(message);

//                tvResult.setText(response.body().string());
            }
        });
    }

    private void initHandler() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {

                if(message.what ==GET_WEB_SUCCESS){
                    String result = (String) message.obj;
                    tvResult.setText(result);

                    return true;
                }
                if(message.what == GET_IMG_SUCCESS){
                    Bitmap bitmap = (Bitmap) message.obj;
                    ivResult.setImageBitmap(bitmap);
                }

                return false;
            }
        });
    }

    private void getWebUseOkHttp() {

        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://www.baidu.com";
        final Request request = new Request.Builder().url(url).build();
        okhttp3.Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.e("MainActivity",e.toString());
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {

                Message message = Message.obtain();
                message.what = GET_WEB_SUCCESS;
                message.obj = response.body().string();
                handler.sendMessage(message);

//                tvResult.setText(response.body().string());
            }
        });

    }
}
