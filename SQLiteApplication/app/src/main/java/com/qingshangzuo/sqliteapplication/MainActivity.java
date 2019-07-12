package com.qingshangzuo.sqliteapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button btnCreateDB;
    private Button btnCreateTable;
    private SQLiteDatabase db;
    private Button btnInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreateDB = (Button) findViewById(R.id.btn_createdb);
        btnCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = getFilesDir().getAbsolutePath() + File.separator + "my.db";
                db = SQLiteDatabase.openOrCreateDatabase(path,null);
            }
        });

        btnCreateTable = (Button) findViewById(R.id.btn_createTable);
        btnCreateTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String createStuSql = "create table if not exists student (id int, name varchar(20), age int);";
                if(db == null) {
                    String path = getFilesDir().getAbsolutePath() + File.separator + "my.db";
                    db = SQLiteDatabase.openOrCreateDatabase(path,null);
                }

                db.execSQL(createStuSql);
            }
        });

        // 教学资源  前两周  Android  SQlite export


        btnInsert = (Button) findViewById(R.id.btn_Insert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(db == null) {
                    String path = getFilesDir().getAbsolutePath() + File.separator + "my.db";
                    db = SQLiteDatabase.openOrCreateDatabase(path,null);
                }

                // 第一种方式   组装insert语句
                /**
                 int num = 1602;
                 String name = "健财";
                 int age =20;

                 String insertSQL = "insert into student values ("+num+", '"+name+"', "+age+")";
                 db.execSQL(insertSQL);
                 */

                // 第二种方式
                ContentValues values = new ContentValues();
                values.put("id", 1688);
                values.put("name", "超浓");
                values.put("age", 19);
                db.insert("student", null, values);

            }
        });
    }
}
