package com.qingshangzuo.dbhelperapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Test2Activity";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        DBHelper dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.query("select * from " , null);

        listView.setAdapter(new CursorAdapter(this, cursor));
    }

    private void init() {
        Log.d(TAG, "Initialing UI Component");
        this.listView = (ListView) this.findViewById(R.id.ListView01);
    }
}
