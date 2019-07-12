package com.qingshangzuo.listviewsql2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity {

    private EditText edtName;
    private EditText edtAge;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("NAME", name);
                intent.putExtra("AGE", age);
                setResult(2002, intent);
                finish();
            }
        });
    }
}
