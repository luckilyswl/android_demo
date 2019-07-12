package com.qingshangzuo.listviewsql2;

public class SeqList {

    private final int MAX = 100;
    private Student[] arr = new Student[MAX];

    // index 指向当前数组内容的末尾
    private int index = 0;

    public void add(Student s){
        arr[index] = s;
        index++;
    }

    public void add(int position, Student s){
        for(int i=index-1; i>=position;i--){
            arr[i+1] = arr[i];
        }
        arr[position] = s;
        index++;
    }

    public void remove(int position){
        for(int i=position; i<index; i++){
            arr[i] = arr[i+1];
        }
        index--;
    }

    public void display(){
        for(int i=0; i<index; i++){
            System.out.print(arr[i] + "   ");
        }
        System.out.println("本次打印完成");
    }

    public int size(){
        return index;
    }

    public Student get(int position){
        return arr[position];
    }

}
