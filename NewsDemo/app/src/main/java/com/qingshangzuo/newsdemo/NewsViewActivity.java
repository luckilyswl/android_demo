package com.qingshangzuo.newsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.BmobUser;

public class NewsViewActivity extends AppCompatActivity {

    private String newsUrl;
    private WebView webView;
    private EditText edtComment;
    private Button btnComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);

        newsUrl = getIntent().getStringExtra("NEWS_URL");

        webView = findViewById(R.id.wv_news);
        webView.loadUrl(newsUrl);

        initCommentViews();

    }

    private void initCommentViews() {
        edtComment = findViewById(R.id.edt_comment);
        btnComment = findViewById(R.id.btn_comment);
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getCurrentUser(Comment.class) 注意可能会出错
                if(BmobUser.getCurrentUser(Comment.class) == null){
                    Intent intent = new Intent();
                    intent.setClass(NewsViewActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}