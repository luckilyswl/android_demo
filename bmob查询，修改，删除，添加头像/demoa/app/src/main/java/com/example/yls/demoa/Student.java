package com.example.yls.demoa;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by yls on 2018/5/3.
 */

public class Student extends BmobObject {
    public BmobFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(BmobFile imgFile) {
        this.imgFile = imgFile;
    }

    private BmobFile imgFile;

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    String stuno;
    String name;
    Integer age;

    @Override
    public String toString() {
        return "id:"+getObjectId()+" stuno:"+stuno+" name:"+name+" age"+age;
    }
}
