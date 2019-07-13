package com.qingshangzuo.bmobperson;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import cn.bmob.v3.Bmob;

public class BaseActivity extends Activity {

    private String Bmob_AppId =
            "f7b5a03549d57f20c7f0954933125803";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,Bmob_AppId);
    }

    Toast mToast;
    public void ShowToast(String text){
        if(!TextUtils.isEmpty(text)){
            if(mToast == null){
                mToast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
            }else{
                mToast.setText(text);
            }
            mToast.show();
        }

    }
}
