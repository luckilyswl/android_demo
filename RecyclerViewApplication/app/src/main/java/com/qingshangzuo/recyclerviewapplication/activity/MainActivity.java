package com.qingshangzuo.recyclerviewapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qingshangzuo.recyclerviewapplication.R;
import com.qingshangzuo.recyclerviewapplication.adapter.StuAdapter;
import com.qingshangzuo.recyclerviewapplication.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvStu;
    private ArrayList<Student> stuData = new ArrayList<>();
    private StuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvStu = (RecyclerView) findViewById(R.id.rv_stu);

        initData();
        adapter = new StuAdapter(stuData);

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rvStu.setLayoutManager(llm);
        rvStu.setAdapter(adapter);
    }

    private void initData() {
        Student s1 = new Student(R.drawable.dog1, "曾派");
        Student s2 = new Student(R.drawable.dog2, "吴霞");
        Student s3 = new Student(R.drawable.dog3, "冯强");
        Student s4 = new Student(R.drawable.dog4, "罗娴");
        Student s5 = new Student(R.drawable.dog5, "吴浓");
        Student s6 = new Student(R.drawable.dog6, "吴海");
        Student s7 = new Student(R.drawable.dog7, "周锋");
        Student s8 = new Student(R.drawable.dog8, "林升");
        stuData.add(s1);
        stuData.add(s2);
        stuData.add(s3);
        stuData.add(s4);
        stuData.add(s5);
        stuData.add(s6);
        stuData.add(s7);
        stuData.add(s8);

    }


}

