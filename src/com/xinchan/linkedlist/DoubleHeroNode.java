package com.xinchan.linkedlist;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-24
 */
public class DoubleHeroNode {
    private int no;
    private String name;
    private String nickname;
    private DoubleHeroNode next;
    private DoubleHeroNode pre;

    public DoubleHeroNode() {
    }

    public DoubleHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public DoubleHeroNode getPre() {
        return pre;
    }

    public void setPre(DoubleHeroNode pre) {
        this.pre = pre;
    }

    public DoubleHeroNode getNext() {
        return next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNext(DoubleHeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
    }
}
