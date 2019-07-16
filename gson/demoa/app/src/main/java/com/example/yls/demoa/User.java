package com.example.yls.demoa;

/**
 * Created by yls on 2018/4/11.
 */

public class User {
    private String name;
    private int age;
    private boolean isMan;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "name:"+name+" , age:"+age+" , isMan:"+isMan+" , sex:"+sex;
    }


}
