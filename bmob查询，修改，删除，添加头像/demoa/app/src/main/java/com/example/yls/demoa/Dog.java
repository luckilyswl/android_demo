package com.example.yls.demoa;

import cn.bmob.v3.BmobObject;

/**
 * Created by yls on 2018/5/3.
 */

public class Dog extends BmobObject {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    String color;
    Integer age;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    Integer weight;
}
