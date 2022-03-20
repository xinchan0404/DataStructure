package com.xinchan.datastructure.linkedlist;

import java.util.Stack;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */
public class InterviewLinkedList {
    // no instance field

    public HeroNode getReversedNode(SingleLinkedList list, int index) {
        if (list.getHead().getNext() == null) {
            System.out.println("链表为空~~");
            return null;
        }

        int len = list.getLen();
        if (index > len || index <= 0) {
            System.out.printf("倒数第 %d 个结点不存在\n", index);
            return null;
        } else {
            return list.get(len - index + 1);
        }
    }


    public void reversedLinkedList(SingleLinkedList list) {
        HeroNode headTemp = new HeroNode();  // 用于临时链表头结点
        HeroNode temp = list.getHead();

        if (temp.getNext() == null || temp.getNext().getNext() == null) {  // 链表为空或链表只有一个数据节点，直接返回
            return;
        }

        while (temp.getNext() != null) {
            HeroNode cur = temp.getNext();
            temp.setNext(temp.getNext().getNext());
            cur.setNext(headTemp.getNext());
            headTemp.setNext(cur);
        }

        temp.setNext(headTemp.getNext());
    }


    /**
     * 逆序打印单链表，但是不改动单链表本身
     * @param list 需要逆序打印的单链表
     */
    public void reversedPrint(SingleLinkedList list) {
        if (list.getHead().getNext() == null) {
            System.out.println("链表为空~~");
        }

        HeroNode temp = list.getHead();
        Stack<HeroNode> stack = new Stack<>();

        while (temp.getNext() != null) {
            stack.push(temp.getNext());  // 入栈

            temp = temp.getNext();  // 后移
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());  // 出栈
        }
    }


    public SingleLinkedList mergeTwoLinkedList(SingleLinkedList list1, SingleLinkedList list2) {
        SingleLinkedList listMerge = new SingleLinkedList();

        if (list1.getHead().getNext() == null && list2.getHead().getNext() == null) {
            System.out.println("待合并的两个链表均为空~~");
        } else if (list1.getHead().getNext() == null && list2.getHead().getNext() != null) {
            listMerge.getHead().setNext(list2.getHead().getNext());
        } else if (list1.getHead().getNext() != null && list2.getHead().getNext() == null) {
            listMerge.getHead().setNext(list1.getHead().getNext());
        } else {
            HeroNode temp1 = list1.getHead();
            HeroNode temp2 = list2.getHead();
            HeroNode tempListMerge = listMerge.getHead();

            while (temp1.getNext() != null && temp2.getNext() != null) {
                if (temp1.getNext().getNo() >= temp2.getNext().getNo()) {
                    HeroNode curList2 = temp2.getNext();
                    temp2.setNext(temp2.getNext().getNext());
                    tempListMerge.setNext(curList2);
                } else {
                    HeroNode curList1 = temp1.getNext();
                    temp1.setNext(temp1.getNext().getNext());
                    tempListMerge.setNext(curList1);
                }
                tempListMerge = tempListMerge.getNext();
            }

            if (temp1.getNext() == null) {
                tempListMerge.setNext(temp2.getNext());
            } else {
                tempListMerge.setNext(temp1.getNext());
            }
        }

        return listMerge;
    }
}
