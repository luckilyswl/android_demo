package com.qingshangzuo.recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddActivity extends AppCompatActivity {

    private ImageView addimage;
    private EditText addname;
    private Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addimage = findViewById(R.id.add_image);
        addname = findViewById(R.id.add_name);
        addbtn = findViewById(R.id.add_btn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int image=Integer.parseInt(addimage.getDrawable().toString());
                String name=addname.getText().toString();

                Intent intent=new Intent();
                intent.putExtra("IMAGE",image);
                intent.putExtra("NAME",name);
                setResult(2,intent);
                finish();
            }
        });
    }
};