package com.qingshangzuo.newstoutiao;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String yuleUrl = "http://v.juhe.cn/toutiao/index?type=yule&key=70369781e35bbc580f7df44a1c2f1b43";
    private String tiyuUrl = "http://v.juhe.cn/toutiao/index?type=tiyu&key=78971bf055a3d6770a3a5e8fe3acf9ab";
    private String topUrl = "http://v.juhe.cn/toutiao/index?type=top&key=78971bf055a3d6770a3a5e8fe3acf9ab";

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private NewsData newsData;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        getDataFromApi();
    }

    private void initHandle(){
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                Log.e("MainAcitivity", "handleMessage");
                adapter.changData(newsData);
                return false;
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(MainActivity.this,newsData);
        recyclerView.setAdapter(adapter);
    }

    // 获取接口数据
    private void getDataFromApi() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(yuleUrl).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("MainActivity", "请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String newsDataJsonStr = response.body().string();
                Log.e("MainActivity", "newsDataJsonStr = " + newsDataJsonStr);
                newsData = new Gson().fromJson(newsDataJsonStr, NewsData.class);

                handler.sendEmptyMessage(1001);
            }
        });
    }
}
