package com.qingshangzuo.listviewsql;

/**
 * Created by yls on 2017/11/8.
 */

public class Student {
    public Student(int id, String name, int age){
        this.id= id;
        this.name = name;
        this.age =age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id;
    private String name;
    private int age;
}
