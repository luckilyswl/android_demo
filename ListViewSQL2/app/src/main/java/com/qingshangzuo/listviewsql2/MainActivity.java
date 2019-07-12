package com.qingshangzuo.listviewsql2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private ListView lvStu;
    private ArrayList<Student> stuList = new ArrayList();
    private StuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initViews();
    }

    private void initData() {
        Student s1 = new Student("黄润",17);
        Student s2 = new Student("蔡望",18);
        Student s3 = new Student("王鸿",19);
        Student s4 = new Student("谢涛",20);
        Student s5 = new Student("冯强",21);

        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
        stuList.add(s4);
        stuList.add(s5);
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
        stuList.add(s4);
        stuList.add(s5);
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
        stuList.add(s4);
        stuList.add(s5);
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
        stuList.add(s4);
        stuList.add(s5);
    }

    private void initViews() {
        btnAdd = (Button) findViewById(R.id.btn_add);
        lvStu = (ListView) findViewById(R.id.lv_stu);

        adapter = new StuAdapter(MainActivity.this, stuList);
        lvStu.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 1001);
            }
        });

        lvStu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 吐司  Toast
                Toast.makeText(MainActivity.this, "您点击了 " + stuList.get(position).getName(), Toast.LENGTH_SHORT).show();

                String name = stuList.get(position).getName();
                int age = stuList.get(position).getAge();

                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("AGE", age);
                intent.putExtra("INDEX", position);
                startActivityForResult(intent, 1002);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data == null){
            return;
        }

        if(resultCode == 2002){
            String name =  data.getStringExtra("NAME");
            int age = data.getIntExtra("AGE", -1);
            Student s =  new Student(name, age);
            stuList.add(0, s);
            adapter.notifyDataSetChanged();
        }

        else if(resultCode == 2003){
            String name =  data.getStringExtra("NAME");
            int age = data.getIntExtra("AGE", -1);
            int pos = data.getIntExtra("INDEX", -1);

            stuList.get(pos).setName(name);
            stuList.get(pos).setAge(age);
            adapter.notifyDataSetChanged();
        }
    }
}

