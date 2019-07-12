package com.qingshangzuo.intentsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class InputActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtAge;
    private RadioButton radioBoy;
    private Button btnConfirm;
    private final int RESULT_CODE = 2001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        initViews();
    }

    private void initViews() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtAge = (EditText) findViewById(R.id.edt_age);
        radioBoy = (RadioButton) findViewById(R.id.radioBoy);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());
                boolean isBoy = radioBoy.isChecked();

                Intent intentb = new Intent();
                intentb.putExtra("NAME", name);
                intentb.putExtra("AGE", age);
                intentb.putExtra("ISBOY", isBoy);

                setResult(RESULT_CODE , intentb);

                finish();
            }
        });
    }
}

