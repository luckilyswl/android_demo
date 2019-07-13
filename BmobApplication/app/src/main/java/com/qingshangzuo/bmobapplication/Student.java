package com.qingshangzuo.bmobapplication;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Student extends BmobObject {

    String stuno;
    String name;
    Integer age;
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

    public BmobFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(BmobFile imgFile) {
        this.imgFile = imgFile;
    }
}
