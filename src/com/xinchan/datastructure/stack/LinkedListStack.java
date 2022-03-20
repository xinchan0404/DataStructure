package com.xinchan.datastructure.stack;

import com.xinchan.datastructure.linkedlist.HeroNode;
import com.xinchan.datastructure.linkedlist.SingleLinkedList;

import java.util.Stack;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-29
 */
public class LinkedListStack {
    private SingleLinkedList singleLinkedList;
    private HeroNode top;


    public LinkedListStack() {
        singleLinkedList = new SingleLinkedList();
        top = singleLinkedList.getHead();
    }


    public boolean isEmpty() {
        return top == singleLinkedList.getHead();
    }


    /**
     * 入栈
     * @param heroNode 待入栈的节点
     */
    public void push(HeroNode heroNode) {
        singleLinkedList.add(heroNode);
        top = top.getNext();
    }


    /**
     * 出栈
     * @return 待出栈的节点
     */
    public HeroNode pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~");
        }

        HeroNode curNode = singleLinkedList.getHead();
        while (curNode.getNext() != top) {
            curNode = curNode.getNext();
        }

        HeroNode popNode = top;
        top = curNode;
        curNode.setNext(null);

        return popNode;
    }


    /**
     * 遍历栈（从栈顶到栈底）
     */
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~");
        }

        HeroNode temp = singleLinkedList.getHead();
        Stack<HeroNode> stack = new Stack<>();

        while (temp.getNext() != null) {
            stack.push(temp.getNext());  // 入栈

            temp = temp.getNext();  // 后移
        }

        while (stack.size() > 0) {
            System.out.println("出栈节点为：" + stack.pop());  // 出栈
        }
    }
}
