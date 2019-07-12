package com.qingshangzuo.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView stuListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stuListView = findViewById(R.id.stu_listView);

        Student s1 = new Student(R.drawable.dog1,"小武",89);
        Student s2 = new Student(R.drawable.dog2,"小陆",89);
        Student s3 = new Student(R.drawable.dog3,"小柒",89);
        Student s4 = new Student(R.drawable.dog4,"小捌",89);
        Student s5 = new Student(R.drawable.dog5,"小玖",89);

        Student[] stuData = {s1,s2,s3,s4,s5};

        StuAdapter adapter = new StuAdapter(MainActivity.this,stuData);
        stuListView.setAdapter(adapter);
    }
}
