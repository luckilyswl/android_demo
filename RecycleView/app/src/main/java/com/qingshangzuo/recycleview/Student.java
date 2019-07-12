package com.qingshangzuo.recycleview;

/**
 * 学生类
 */

public class Student {
    private int headImage;
    private String name;

    public Student(int headImage,String name){
        this.headImage=headImage;
        this.name=name;
    }

    public int getHeadImage() {
        return headImage;
    }

    public String getName() {
        return name;
    }
}
