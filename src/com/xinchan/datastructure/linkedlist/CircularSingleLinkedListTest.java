package com.xinchan.datastructure.linkedlist;

/**
 * @author zhengxin
 * @version 1.0.1 2021-09-27
 */
public class CircularSingleLinkedListTest {
    public static void main(String[] args) {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        try {
            // 测试 init 方法
            System.out.println("测试 init 方法~~");
            circularSingleLinkedList.init(3);

            // 测试 show 方法
            System.out.println("\n测试 show 方法~~");
            System.out.println("遍历当前单向环形链表：");
            circularSingleLinkedList.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 add 方法
        System.out.println("\n测试 add 方法~~");
        Node node1 = new Node(3);
        Node node2 = new Node(7);
        Node node3 = new Node(9);

        circularSingleLinkedList.add(node1);  // 异常测试
        circularSingleLinkedList.add(node2);
        circularSingleLinkedList.add(node3);

        System.out.println("遍历当前单向环形链表：");
        circularSingleLinkedList.show();

        // 测试 addByOrder 方法
        System.out.println("\n测试 addByOrder 方法~~");
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        Node node6 = new Node(-1);
        circularSingleLinkedList.addByOrder(node4);  // 异常测试
        circularSingleLinkedList.addByOrder(node5);
        circularSingleLinkedList.addByOrder(node6);  // 异常测试

        System.out.println("遍历当前单向环形链表：");
        circularSingleLinkedList.show();

        // 测试 size 方法
        System.out.println("\n测试 size 方法~~");
        System.out.println("当前单向环形链表长度为 " + circularSingleLinkedList.size());

        // 测试 remove 方法
        System.out.println("\n测试 remove 方法~~");
        try {
            int[] removeSort = circularSingleLinkedList.remove(2, 2);
            System.out.println("节点出单向循环链表顺序：");
            for (int i = 0; i < removeSort.length; i++) {
                if (i == removeSort.length - 1) {
                    System.out.print(removeSort[i] + "\n");
                } else {
                    System.out.print(removeSort[i] + " -> ");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("遍历当前单向环形链表：");
        circularSingleLinkedList.show();
    }
}
