package com.qingshangzuo.recyclerviewapplication.model;

/**
 * Created by yls on 2017/11/1.
 */

public class Student {
    public  Student(int headImg,String name){
        this.name = name;
        this.headImg = headImg;
    }


    public int getHeadImg() {
        return headImg;
    }

    public String getName() {
        return name;
    }

    private  int headImg;
    private String name;
}
