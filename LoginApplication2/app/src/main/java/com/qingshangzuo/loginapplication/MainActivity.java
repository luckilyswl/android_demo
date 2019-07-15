package com.qingshangzuo.loginapplication;

import android.annotation.SuppressLint;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 这个就是登陆界面的activity
 * 注册  登陆   忘记密码    要考虑这几种情况 转其他activity
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

    //声明控件对象
    private EditText edt_name,edt_pwd;
    private Button mLoginButton,mLoginError,mRegister,ONLYTEST;
    int selectIndex = 1;
    int tempSelect = selectIndex;
    private boolean flase;
    boolean isReLogin = flase;
    private int SERVER_FALG = 0;
    private RelativeLayout countryselect;
    private TextView country_phone_sn , countryName;

    //消息的常量值
    private final static int LOGIN_ENABLE = 0x01;
    private final static int LOGIN_UNABLF = 0x02;
    private final static int PASS_ERROR = 0x03;
    private final static int NAME_ERROR = 0x04;

    final Handler UiManagerHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case LOGIN_ENABLE:
                    mLoginButton.setClickable(true);
                    break;
                case LOGIN_UNABLF:
                    mLoginButton.setClickable(false);
                    break;
                case PASS_ERROR:
                    //mLoginButton.setClickable(false);
                    break;
                case NAME_ERROR:
                    //mLoginButton.setClickable(false);
                    break;

            }
            super.handleMessage(msg);
        }
    };

    //文本监视器
    private Button btn_username_clear;
    private Button btn_pwd_clear;
    private Button btn_pwd_eye;
    private TextWatcher username_watcher;
    private TextWatcher password_watcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //edt_name = findViewById(R.id.bt_usename_clear);
        //edt_pwd = findViewById(R.id.bt_pwd_clear);
        btn_username_clear = findViewById(R.id.bt_usename_clear);
        btn_pwd_clear = findViewById(R.id.bt_pwd_clear);
        btn_pwd_eye = findViewById(R.id.bt_pwd_eyes);

        btn_username_clear.setOnClickListener(this);
        btn_pwd_eye.setOnClickListener(this);
        btn_pwd_clear.setOnClickListener(this);

        //TODO
        initWatcher();
        edt_name.addTextChangedListener(username_watcher);
        edt_pwd.addTextChangedListener(password_watcher);

        mLoginButton = findViewById(R.id.login);
        mLoginError = findViewById(R.id.login_error);
        mRegister = findViewById(R.id.register);

        ONLYTEST.setOnClickListener(this);
        ONLYTEST.setOnLongClickListener(this);
        mLoginButton.setOnClickListener(this);
        mLoginError.setOnClickListener(this);
        mRegister.setOnClickListener(this);

    }

    private void initWatcher() {
        username_watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                edt_pwd .setText("");
                if(editable.toString().length() > 0){
                    btn_username_clear.setVisibility(View.VISIBLE);
                }else{
                    btn_username_clear.setVisibility(View.INVISIBLE);
                }
            }
        };

        password_watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {  //表示最终内容
                if (editable.toString().length()>0){
                    btn_pwd_clear.setVisibility(View.VISIBLE);
                }else{
                    btn_pwd_clear.setVisibility(View.INVISIBLE);
                }

            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //登陆activity
            case R.id.login:
                //login();
                break;
                //忘记密码
            case R.id.login_error:
                break;
                //注册
            case R.id.register:
                break;
        }

    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.register:
                if(SERVER_FALG > 9){
                    break;
                }
        }

        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if (isReLogin){

            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
