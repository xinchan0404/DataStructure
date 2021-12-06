package com.xinchan.linkedlist;

/**
 * 每个 heroNode 对象就是单链表的一个结点
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */

public class HeroNode {
    private int no;
    private String name;
    private String nickname;
    private HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode getNext() {
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

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
    }
}
