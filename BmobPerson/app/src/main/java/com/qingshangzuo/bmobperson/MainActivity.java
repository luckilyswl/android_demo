package com.qingshangzuo.bmobperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.InsertListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends  BaseActivity implements View.OnClickListener {

    private Button btnAdd,btnDelete,btnUpdate,btnQuery;

    private String objectId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();   //初始化按钮
        initListener();   //监听按钮
    }

    private void initView() {
        btnAdd = findViewById(R.id.btn_add);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_update);
        btnQuery = findViewById(R.id.btn_query);
    }

    private void initListener() {
        btnAdd.setOnClickListener((View.OnClickListener) this);
        btnDelete.setOnClickListener((View.OnClickListener) this);
        btnUpdate.setOnClickListener((View.OnClickListener) this);
        btnQuery.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v){
        if(v == btnAdd){
            createPerson();
        }else if(v == btnDelete){
            deletePersonByObjectId();
       }else if(v == btnUpdate){
            updatePersonByObjectId();
        }else{
            queryPersonByObjectId();
        }
    }

    private void createPerson(){
        final Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("广州海珠");
        p2.insertObject(this, new InsertListener() {
            @Override
            public void onSuccess() {
                ShowToast("创建数据成功:" + p2.getObjectId());
                objectId = p2.getObjectId();
            }

            @Override
            public void onFailure(String msg) {
                ShowToast("创建数据失败：" + msg);
            }
        });
    }

    private void updatePersonByObjectId(){
        final Person p2 = new Person();
        p2.setName("luckily");
        p2.setAddress("广州天河");
        p2.updateObject(this, objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                ShowToast("更新成功：更新后的地址->" + p2.getAddress());
            }

            @Override
            public void onFailure(String msg) {
                ShowToast("更新失败：" + msg);
            }
        });
    }

    private void deletePersonByObjectId() {
        Person p2 = new Person();
        p2.setObjectId(objectId);
        p2.deleteObject(this, new DeleteListener() {
            @Override
            public void onSuccess() {
                ShowToast("删除成功");
            }

            @Override
            public void onFailure(String msg) {
                ShowToast("删除失败：" + msg);
            }
        });
    }

    /** 查询指定ObjectId的person数据
     * queryPerson
     * @Title: queryPerson
     * @throws
     */
    private void queryPersonByObjectId() {
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject(this, objectId, new GetListener<Person>() {
            @Override
            public void onSuccess(Person object) {
                // TODO Auto-generated method stub
                ShowToast("查询成功:名称->"+object.getName()+"，地址->"+object.getAddress());
            }

            @Override
            public void onFailure(String msg) {
                // TODO Auto-generated method stub
                ShowToast("查询失败：" + msg);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

