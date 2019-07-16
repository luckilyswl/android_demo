package com.qingshangzuo.newstoutiao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;

public class LoginActivity extends AppCompatActivity {
    private EditText edtPhone;
    private EditText edtCode;
    private Button btnGetCode;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtPhone = findViewById(R.id.edt_phone);
        edtCode = findViewById(R.id.edt_code);
        btnGetCode = findViewById(R.id.btn_getCode);
        btnLogin = findViewById(R.id.btn_login);

        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhone.getText().toString();
                BmobSMS.requestSMSCode(phone, "", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer smsId, BmobException ex) {
                        if (ex == null) {//验证码发送成功
                            Log.i("smile", "短信id：" + smsId);//用于后续的查询本次短信发送状态
                        }
                    }
                });
            }
        });

              btnLogin.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                         String phone = edtPhone.getText().toString();
                         String code = edtCode.getText().toString();
                         BmobUser.loginBySMSCode(phone, code, new LogInListener<BmobUser>() {

                               @Override
                               public void done(BmobUser user, BmobException e) {
                                      if (user != null) {
                                          Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                      }
                               }
                          });
                  }
              }
        );
    }
}
