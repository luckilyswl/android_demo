package com.qingshangzuo.listviewsql2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtAge;
    private Button btnSave;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initViews();

        String name = getIntent().getStringExtra("NAME");
        int age =  getIntent().getIntExtra("AGE", -1);
        pos = getIntent().getIntExtra("INDEX", 0);

        edtName.setText(name);
        edtAge.setText(String.valueOf(age));
    }

    private void initViews() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        btnSave = (Button) findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("NAME", name);
                intent.putExtra("AGE", age);
                intent.putExtra("INDEX", pos);

                setResult(2003, intent);
                finish();
            }
        });
    }
}
