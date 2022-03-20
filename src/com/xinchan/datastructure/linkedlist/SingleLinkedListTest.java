package com.xinchan.datastructure.linkedlist;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "无用", "智少星");
        HeroNode node4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5, "关输", "小刀");
        HeroNode node6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode node3_1 = new HeroNode(3, "吴用", "智多星");
        HeroNode node5_1 = new HeroNode(5, "关胜", "大刀");

        // 测试 add 方法
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);

        // 测试 addByOrder 方法
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node6);
        singleLinkedList.addByOrder(node5);

        // 修改前
        System.out.println("修改前~~");
        try {
            singleLinkedList.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 update 方法
        singleLinkedList.update(node3_1);
        singleLinkedList.update(node5_1);

        // 修改后
        System.out.println("修改后~~");
        try {
            singleLinkedList.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 delete 方法
        singleLinkedList.delete(1);
        singleLinkedList.delete(3);
        singleLinkedList.delete(6);
        singleLinkedList.delete(2);

        // 删除后
        System.out.println("删除后~~");
        try {
            singleLinkedList.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 get 方法
        System.out.println("查找结点~~");
        HeroNode getNode1 = singleLinkedList.get(4);
        System.out.printf("链表中编号为 %d 的结点: %s\n", getNode1.getNo(), getNode1);
        HeroNode getNode2 = singleLinkedList.get(5);
        System.out.printf("链表中编号为 %d 的结点: %s\n", getNode2.getNo(), getNode2);

        // 测试 getLen 方法
        System.out.println("查询链表当前长度~~");
        System.out.println("链表当前长度为：" + singleLinkedList.getLen());
    }
}
