package com.qingshangzuo.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    int i = -1;

    private ImageView imageView;

    private String arr[] = {
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3893146502,314297687&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1269541597,1719556527&fm=27&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1718395925,3485808025&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=508387608,2848974022&fm=27&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1409224092,1124266154&fm=27&gp=0.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv_image);
    }


    public void loadImage(View view) {
        if(i<5){
            i++;
            Glide.with(this).load(arr[i]).into(imageView);
        }
        if(i>=4){
            i = -1;
        }
    }

    public void loadImage1(View view) {
        if(i>0){
            i--;
            Glide.with(this).load(arr[i]).into(imageView);
        }
        if(i<=0){
            i=5;
        }
    }

}
