package com.example.yls.demoa;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yls on 2018/4/11.
 */

public class User {

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String name;

    private int age;

    @SerializedName("is_man")
    private boolean isMan;

    private String sex;

    @Override
    public String toString() {
        return "姓名"+name+" 年龄"+age + " 是否男" + isMan + " 性别" +sex;
    }
}
