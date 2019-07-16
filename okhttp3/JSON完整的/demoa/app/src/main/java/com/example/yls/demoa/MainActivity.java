package com.example.yls.demoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CTRL+SHIFT+空格
        findViewById(R.id.btn_parse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  /*               将json字符串转成单个java对象
                parseJsonStrToJavaObjUseGson();
                 将json字符串转成java对象数组
                parseJsonStrToJavaArrayUseGson();
                 将json字符串转成java对象列表
                parseJsonStrToJavaListUseGson();
                 将json字符串转成java对象 使用GsonFormat创建类
                parseJsonStrToJavaWithGsonFormat();
                 将json字符串转成java列表 使用GsonFormat创建类
                parseJsonStrToJavaListWithGsonFormat();
                 将Java对象转换成json字符串
                parseJavaObjToJsonStrWithGson();
                将Java对象列表转换成json字符串
                parseJavaListToJsonStrWithGson();*/
            }


        });

    }

    private void parseJavaObjToJsonStrWithGson() {
//        Book book = new Book("Java高级进阶","19.99", true);
        UserList userList = new UserList();
        List<UserList.UserBean> list = new ArrayList<>();
        list.add(new UserList.UserBean("张三","18",true));
        list.add(new UserList.UserBean("里斯","19",false));
        userList.setUser(list);
        Gson gson = new Gson();

        String json = gson.toJson(userList);
        Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();

    }

    private void parseJsonStrToJavaListWithGsonFormat() {
        String jsonStr = "{\n" +
                "    \"user\": [\n" +
                "        {\n" +
                "            \"name\": \"alex\",\n" +
                "            \"age\": \"18\",\n" +
                "            \"is_man\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"mahao\",\n" +
                "            \"age\": \"16\",\n" +
                "            \"is_man\": true\n" +
                "        },\n" +
                "\t\t{\n" +
                "            \"name\": \"mahao\",\n" +
                "            \"age\": \"16\",\n" +
                "            \"is_man\": true\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Gson gson = new Gson();

        UserList userList = gson.fromJson(jsonStr,UserList.class);
        List<UserList.UserBean> list = userList.getUser();
        for(int i=0; i<list.size();i++){
            Log.e("USERLIST", list.get(i).toString());
        }

    }

    private void parseJsonStrToJavaWithGsonFormat() {
        String jsonStr ="{ \"name\": \"Android 从入门到放弃\", \"price\": 18.88,\"isImportant\": true}";
        Gson gson = new Gson();
        Book book = gson.fromJson(jsonStr,Book.class);
        Toast.makeText(MainActivity.this, book.toString(),Toast.LENGTH_SHORT).show();


    }

    private void parseJsonStrToJavaListUseGson() {
        String jsonStr = "[{ \"name\": \"alex\", \"age\": \"18\",\"is_man\": true},\n" +
                " {\"name\": \"mahao\",\"age\": \"16\",\"is_man\": true}]";
        Gson gson = new Gson();
        List<User> userList = gson.fromJson(jsonStr,
                new TypeToken<List<User>>(){}.getType());

        for(int i=0; i<userList.size();i++){
            Log.e("USERLIST", userList.get(i).toString());
        }


    }

    private void parseJsonStrToJavaArrayUseGson() {
        String jsonStr = "[{ \"name\": \"alex\", \"age\": \"18\",\"is_man\": true},\n" +
                " {\"name\": \"mahao\",\"age\": \"16\",\"is_man\": true}]";

        Gson gson = new Gson();
        User[] users = gson.fromJson(jsonStr, User[].class);

        for(int i=0; i<users.length;i++){
            Log.e("USERS", users[i].toString());
        }
    }

    private void parseJsonStrToJavaObjUseGson() {

        String jsonStr ="{\"name\": \"alex\",\"age\": \"18\",\"isMan\": true}";

        Gson gson = new Gson();
        User user = gson.fromJson(jsonStr, User.class);

        Toast.makeText(MainActivity.this, user.toString(),Toast.LENGTH_SHORT).show();
    }
}
