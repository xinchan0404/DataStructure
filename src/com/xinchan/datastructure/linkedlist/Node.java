package com.xinchan.datastructure.linkedlist;

/**
 * @author zhengxin
 * @version 1.0.1 2021-09-27
 */
public class Node {
    private int no;
    private Node next;

    public Node() {
    }

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Node getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "no=" + no + '}';
    }
}
