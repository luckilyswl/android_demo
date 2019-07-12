package com.qingshangzuo.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtNum;
    private EditText edtName;
    private EditText edtAge;
    private EditText edtScore;
    private Button btnSave;
    private Button btnQuery;
    private TextView txtResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViews();
    }

    private void findViews() {
        edtNum = (EditText) findViewById(R.id.edtNum);
        edtName = (EditText) findViewById(R.id.edtName);
        edtScore = (EditText) findViewById(R.id.edtScore);
        btnSave = (Button) findViewById(R.id.btnSave);
        txtResult = (TextView) findViewById(R.id.txt_result);
        btnQuery = (Button) findViewById(R.id.btnQuery);
        edtAge = (EditText) findViewById(R.id.edtAge);

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer =  new StringBuffer();
                Cursor cur = getContentResolver().query(MyProvider.URI_STU, null, null, null, null);
                //TODO:报错提示45行
                for(cur.moveToFirst();!cur.isAfterLast();cur.moveToNext()){
                    int id = cur.getInt(cur.getColumnIndex(StudentTable.COLUMN_ID));
                    String name = cur.getString(cur.getColumnIndex(StudentTable.COLUMN_NAME));
                    int age = cur.getInt(cur.getColumnIndex(StudentTable.COLUMN_AGE));
                    int score = getScore(id);
                    String result = "id = " + id + " name = " + name + " age = " + age + " score = " + score + "\n" ;
                    buffer.append(result);
                }

                txtResult.setText(buffer.toString());
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:报错提示61行
                int id = Integer.parseInt(edtNum.getText().toString());
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());
                int score = Integer.parseInt(edtScore.getText().toString());

                ContentValues valueStu = new ContentValues()                 ;
                valueStu.put(StudentTable.COLUMN_ID, id);
                valueStu.put(StudentTable.COLUMN_NAME, name);
                valueStu.put(StudentTable.COLUMN_AGE, age);
                getContentResolver().insert(MyProvider.URI_STU, valueStu);

                ContentValues valueSco = new ContentValues();
                valueSco.put(ScoreTable.COLUMN_ID, id);
                valueSco.put(ScoreTable.COLUMN_ANDROID, score);
                getContentResolver().insert(MyProvider.URI_SCO, valueSco);
            }
        });
    }

    private int getScore(int id) {
        String where = ScoreTable.COLUMN_ID + " = "+ id;
        Cursor cur = getContentResolver().query(MyProvider.URI_SCO, null, where, null,null );

        if(cur.moveToFirst()){
            return cur.getInt(cur.getColumnIndex(ScoreTable.COLUMN_ANDROID));
        }

        return -1;
    }
}
