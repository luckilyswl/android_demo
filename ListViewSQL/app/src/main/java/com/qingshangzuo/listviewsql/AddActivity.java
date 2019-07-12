package com.qingshangzuo.listviewsql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class AddActivity extends AppCompatActivity {
    private Button btnAdd;
    private EditText edtID;
    private EditText edtName;
    private EditText edtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd = findViewById(R.id.btn_add);
        edtID = findViewById(R.id.edt_id);
        edtAge =  findViewById(R.id.edt_age);
        edtName = findViewById(R.id.edt_name);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int id =  Integer.parseInt( edtID.getText().toString());
                int age = Integer.parseInt( edtAge.getText().toString());


                String path = getFilesDir().getAbsolutePath() + File.separator + "my.db";
                SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path,null);

                ContentValues values = new ContentValues();
                values.put("id", id);
                values.put("name", name);
                values.put("age", age);

                db.insert("student", null, values);

                // 通知MainAcitiy数据库变啦   你要刷新
                //  广播 Broadcast
                finish();
            }
        });
    }
}

