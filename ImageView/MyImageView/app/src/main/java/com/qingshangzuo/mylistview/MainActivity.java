package com.qingshangzuo.mylistview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private static final int MSG_INDEX_CHANGED = 1001;
    private ImageView img_net;
    private Button btnLast;
    private Button btnNext;
    private Handler handler;

    private String url1 =  "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3893146502,314297687&fm=27&gp=0.jpg";
    private String url2 =  "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1269541597,1719556527&fm=27&gp=0.jpg";
    private String url3 =   "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1718395925,3485808025&fm=27&gp=0.jpg";
    private String url4 =   "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=508387608,2848974022&fm=27&gp=0.jpg";
    private String url5 =    "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1409224092,1124266154&fm=27&gp=0.jpg";

    private String[] imgs = {url1, url2, url3, url4, url5};
    private int index = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        initHandler();
    }

    private void initHandler() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_INDEX_CHANGED){
                    Glide.with(MainActivity.this).load(imgs[index]).into(img_net);
                    return true;
                }
                return false;
            }
        });
    }

    private void initViews() {
        img_net = findViewById(R.id.img_net);
        btnLast = findViewById(R.id.btn_Last);
        btnNext = findViewById(R.id.btn_Next);

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index + imgs.length - 1) % imgs.length;
                Glide.with(MainActivity.this).load(imgs[index]).into(img_net);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index + 1) % imgs.length;
                Glide.with(MainActivity.this).load(imgs[index]).into(img_net);
            }
        });
    }

    public  void showImage(){

    }

}
