package com.example.yls.demoa;

/**
 * Created by yls on 2018/4/11.
 */

public class Book {

    /**
     * name : Android 从入门到放弃
     * price : 18.88
     * isImportant : true
     */

    private String name;
    private String price;
    private boolean isImportant;

    public Book(String name, String price, boolean isImportant) {
        this.isImportant = isImportant;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isIsImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }

    @Override
    public String toString() {
        return "书名"+name+"价格"+price+"重要"+isImportant;
    }
}
