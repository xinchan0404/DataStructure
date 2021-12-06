package com.xinchan.linkedlist;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-24
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleHeroNode node1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode node2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode node3 = new DoubleHeroNode(3, "无用", "智少星");
        DoubleHeroNode node4 = new DoubleHeroNode(4, "公孙胜", "入云龙");
        DoubleHeroNode node5 = new DoubleHeroNode(5, "关输", "小刀");
        DoubleHeroNode node6 = new DoubleHeroNode(6, "林冲", "豹子头");
        DoubleHeroNode node3_1 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode node5_1 = new DoubleHeroNode(5, "关胜", "大刀");

        // 测试 add 方法
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);

        // 测试 addByOrder 方法
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node6);
        doubleLinkedList.addByOrder(node5);

        // 修改前
        System.out.println("修改前~~");
        try {
            doubleLinkedList.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 update 方法
        System.out.println("\n测试 update 方法~~");
        doubleLinkedList.update(node3_1);
        doubleLinkedList.update(node5_1);

        // 修改后
        System.out.println("\n修改后~~");
        try {
            doubleLinkedList.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 delete 方法
        System.out.println("\n测试 delete 方法~~");
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(3);
        doubleLinkedList.delete(6);
        doubleLinkedList.delete(2);
//        doubleLinkedList.delete(4);
//        doubleLinkedList.delete(5);
//        doubleLinkedList.delete(5);

        // 删除后
        System.out.println("\n删除后~~");
        try {
            doubleLinkedList.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 get 方法
        System.out.println("\n测试 get 方法~~");
        DoubleHeroNode getNode1 = doubleLinkedList.get(4);
        System.out.printf("链表中编号为 %d 的结点: %s\n", getNode1.getNo(), getNode1);
        DoubleHeroNode getNode2 = doubleLinkedList.get(5);
        System.out.printf("链表中编号为 %d 的结点: %s\n", getNode2.getNo(), getNode2);

        // 测试 getLen 方法
        System.out.println("\n测试 getLen 方法~~");
        System.out.println("链表当前长度为：" + doubleLinkedList.getLen());
    }
}
