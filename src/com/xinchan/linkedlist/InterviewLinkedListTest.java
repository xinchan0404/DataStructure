package com.xinchan.linkedlist;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */
public class InterviewLinkedListTest {
    public static void main(String[] args) {
        InterviewLinkedList interviewLinkedList = new InterviewLinkedList();

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "无用", "智少星");
        HeroNode node4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5, "关输", "小刀");
        HeroNode node6 = new HeroNode(6, "林冲", "豹子头");

        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node5);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node6);

        // 显示链表
        System.out.println("修改前~~");
        try {
            singleLinkedList.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 getReversedNode 方法
        System.out.println("\n测试 getReversedNode 方法~~");
        HeroNode reversedNode = interviewLinkedList.getReversedNode(singleLinkedList, 0);
        System.out.println(reversedNode);
        HeroNode reversedNode1 = interviewLinkedList.getReversedNode(singleLinkedList, 7);
        System.out.println(reversedNode1);
        HeroNode reversedNode2 = interviewLinkedList.getReversedNode(singleLinkedList, 6);
        System.out.println("倒数第 6 个结点：" + reversedNode2);
        HeroNode reversedNode3 = interviewLinkedList.getReversedNode(singleLinkedList, 1);
        System.out.println("倒数第 1 个结点：" + reversedNode3);

        // 测试 reversedLinkedList 方法
        System.out.println("\n测试 reversedLinkedList 方法~~");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        HeroNode node7 = new HeroNode(7, "秦明", "霹雳火");
        HeroNode node8 = new HeroNode(8, "呼延灼", "双鞭将");
        HeroNode node9 = new HeroNode(9, "花荣", "小李广");
        singleLinkedList1.addByOrder(node7);
        singleLinkedList1.addByOrder(node8);
        singleLinkedList1.addByOrder(node9);

        // 反转前
        System.out.println("反转前~~");
        try {
            singleLinkedList1.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 反转链表
        interviewLinkedList.reversedLinkedList(singleLinkedList1);

        // 反转后
        System.out.println("反转后~~");
        try {
            singleLinkedList1.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 reversedPrint 方法
        System.out.println("\n测试 reversedPrint 方法~~");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode node10 = new HeroNode(10, "柴进", "小旋风");
        HeroNode node11 = new HeroNode(11, "李应", "扑天");
        HeroNode node12 = new HeroNode(12, "朱仝", "美髯公");
        singleLinkedList2.addByOrder(node10);
        singleLinkedList2.addByOrder(node11);
        singleLinkedList2.addByOrder(node12);

        // 顺序打印
        System.out.println("顺序打印~~");
        try {
            singleLinkedList2.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 逆序打印
        System.out.println("逆序打印~~");
        try {
            interviewLinkedList.reversedPrint(singleLinkedList2);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 mergeTwoLinkedList 方法
        System.out.println("\n测试 mergeTwoLinkedList 方法~~");
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        SingleLinkedList singleLinkedList4 = new SingleLinkedList();
        HeroNode node13 = new HeroNode(13, "鲁智深", "花和尚");
        HeroNode node14 = new HeroNode(14, "武松", "行者");
        HeroNode node15 = new HeroNode(15, "董平", "双抢将");
        HeroNode node16 = new HeroNode(16, "张清", "没羽箭");
        singleLinkedList3.addByOrder(node13);
        singleLinkedList3.addByOrder(node16);
        singleLinkedList4.addByOrder(node14);
        singleLinkedList4.addByOrder(node15);


        // 合并前的两个链表
        System.out.println("合并前的两个链表~~");
        try {
            System.out.println("链表1~~");
            singleLinkedList3.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("链表2~~");
            singleLinkedList4.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


        // 合并两个链表
        SingleLinkedList singleLinkedList5 = interviewLinkedList.mergeTwoLinkedList(singleLinkedList3, singleLinkedList4);

        // 合并后的链表
        System.out.println("合并后的链表~~");
        try {
            singleLinkedList5.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
