package com.example.yls.demoa;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private String delStuid;
    private String updateStuid;
    private ImageView ivHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        ivHead = findViewById(R.id.iv_head);

        findViewById(R.id.btn_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryStudent();
            }
        });

        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delteStudent(delStuid);
            }
        });

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStudent(updateStuid);
            }
        });

        findViewById(R.id.btn_dog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDog();
            }
        });

        findViewById(R.id.btn_uploadimg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImg();
            }
        });
    }

    private void uploadImg() {
        String filePath = "/mnt/shared/Image/Tulips.jpg";
        final BmobFile bmobFile = new BmobFile(new File(filePath));
        bmobFile.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if(e == null){
                    Student s = new Student();
                    s.setImgFile(bmobFile);
                    s.setObjectId(updateStuid);
                    s.update(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            Toast.makeText(MainActivity.this,
                                    "头像更新成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



    }

    private void createDog() {
        Dog dog = new Dog();
        dog.setAge(3);
        dog.setColor("黑色");
        dog.setName("小黑");
        dog.setWeight(5);
        dog.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                Toast.makeText(MainActivity.this, "旺旺",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateStudent(String updateStuid) {
        Student s = new Student();
        s.setName("阳光");
        s.setAge(88);
        s.setObjectId(updateStuid);
        s.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e ==null){
                    // 更新成功 重新查询
                    queryStudent();
                }
            }
        });
    }

    private void delteStudent(String objId) {
        Student s = new Student();
        s.setObjectId(objId);
        s.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e == null){
                    // 删除成功  再查询一次
                    queryStudent();
                }
            }
        });
    }

    private void queryStudent() {
        BmobQuery<Student> query = new BmobQuery<>();
        query.findObjects(new FindListener<Student>() {
            @Override
            public void done(List<Student> list, BmobException e) {
                if(e == null){
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("个数").append(list.size());
                    for(int i=0; i<list.size();i++){
                        buffer.append("\n").append(list.get(i));
                    }
                    tvResult.setText(buffer);
                    // 记录第一个学生的objid 删除用
                    delStuid = list.get(0).getObjectId();
                    updateStuid = list.get(list.size()-1).getObjectId();

                    String imgUrl =list.get(0).getImgFile().getFileUrl();
                    Glide.with(MainActivity.this).load(Uri.parse(imgUrl)).into(ivHead);
                }
            }
        });
    }
}
