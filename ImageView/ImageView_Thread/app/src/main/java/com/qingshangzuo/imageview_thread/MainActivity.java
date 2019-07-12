package com.qingshangzuo.imageview_thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnPause;
    private ImageView imgNet;

    private String url1 =  "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3893146502,314297687&fm=27&gp=0.jpg";
    private String url2 =  "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1269541597,1719556527&fm=27&gp=0.jpg";
    private String url3 =   "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1718395925,3485808025&fm=27&gp=0.jpg";
    private String url4 =   "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=508387608,2848974022&fm=27&gp=0.jpg";
    private String url5 =    "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1409224092,1124266154&fm=27&gp=0.jpg";

    private String[] imgUrls = {url1,url2,url3,url4,url5};
    private int index = 0;

    private int MSG_IMG_CHANGE = 1002;
    private Handler handler;
    private Thread thread;
    private boolean isPause = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHandler();
        intViews();
        initThread();
    }

    private void initThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(!isPause) {
                        index = (index + 1) % imgUrls.length;
//                            Glide.with(MainActivity.this).load(imgUrls[index]).into(imgNet);
                        // 此处需要发消息到主线程
                        Message msg = Message.obtain();
                        msg.what = MSG_IMG_CHANGE;
                        msg.arg1 = index;
                        handler.sendMessage(msg);
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void initHandler() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_IMG_CHANGE){
                    Glide.with(MainActivity.this).load(imgUrls[msg.arg1]).into(imgNet);
                    return true;
                }
                return false;
            }
        });
    }

    private void intViews() {
        initImageViews();
        initButtons();
    }

    private void initButtons() {
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPause = false;
            }
        });

        btnPause = (Button) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPause = true;
            }
        });
    }

    private void initImageViews() {
        imgNet = (ImageView) findViewById(R.id.img_net);
    }
}
