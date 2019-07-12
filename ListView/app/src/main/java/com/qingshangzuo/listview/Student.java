package com.qingshangzuo.listview;


/**
 * 学生类
 */
public class Student {

    private int headimg;
    private String name;
    private int age;

    public Student(int headimg,String name,int age){
        this.headimg = headimg;
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getHeadimg(){
        return headimg;
    }
}
