package com.qingshangzuo.recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> StudentList=new ArrayList<>();
    private Button stuadd;
    private StuAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initViews();
    }

    private void initViews(){
        stuadd = findViewById(R.id.stu_add);
        recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new StuAdapter(StudentList);
        recyclerView.setAdapter(adapter);
        stuadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,1001);
            }
        });
    }



    private void initData() {
        Student s1=new Student(R.drawable.cc,"John");
        Student s2=new Student(R.drawable.bb,"Pola");
        Student s3=new Student(R.drawable.ee,"Anne");
        Student s4=new Student(R.drawable.aa,"Ann");
        Student s5=new Student(R.drawable.cc,"Nick");
        Student s6=new Student(R.drawable.bb,"Tom");
        Student s7=new Student(R.drawable.aa,"Tony");
        Student s8=new Student(R.drawable.bb,"Lucy");
        Student s9=new Student(R.drawable.cc,"Amy");
        StudentList.add(s1);
        StudentList.add(s2);
        StudentList.add(s3);
        StudentList.add(s4);
        StudentList.add(s5);
        StudentList.add(s6);
        StudentList.add(s7);
        StudentList.add(s8);
        StudentList.add(s9);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data!=null){
            int image=data.getIntExtra("IMAGE",-1);
            String name=data.getStringExtra("NAME");
            Student stu=new Student(image,name);
            StudentList.add(stu);
            adapter.notifyDataSetChanged();

        }
    }


}
