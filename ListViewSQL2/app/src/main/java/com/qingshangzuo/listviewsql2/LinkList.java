package com.qingshangzuo.listviewsql2;

public class LinkList {
    private Node head = new Node();

    // 头插法
    public void add(Student s){
        Node newNode = new Node();
        newNode.s = s;

        newNode.next = head.next;
        head.next = newNode;
    }
}
