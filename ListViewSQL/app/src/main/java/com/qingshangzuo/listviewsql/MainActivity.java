package com.qingshangzuo.listviewsql;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvStu;
    private Button btnAdd;
    private ArrayList<Student> stuData =  new ArrayList<>();
    private SQLiteDatabase db;
    private StuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromSQLite();

        lvStu = (ListView) findViewById(R.id.lv_stu);

        adapter = new StuAdapter(MainActivity.this, stuData);
        lvStu.setAdapter(adapter);

        btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataFromSQLite();
        adapter.notifyDataSetChanged();
    }

    private void  getDataFromSQLite() {
        if(db == null){
            String path = getFilesDir().getAbsolutePath() + File.separator + "my.db";
            db = SQLiteDatabase.openOrCreateDatabase(path,null);
        }

        String createStuSql = "create table if not exists student (id int, name varchar(20), age int);";
        db.execSQL(createStuSql);

        Cursor cur =  db.query("student", null,null, null,null,null,null);

        stuData.clear();

        for(cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()){
            int id = cur.getInt(0);
            String name = cur.getString(1);
            int age =  cur.getInt(2);

            Student s =  new Student(id, name, age);
            stuData.add(s);
        }

        cur.close();
    }
}

