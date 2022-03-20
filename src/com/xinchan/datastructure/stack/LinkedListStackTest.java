package com.xinchan.datastructure.stack;

import com.xinchan.datastructure.linkedlist.HeroNode;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-29
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();

        // 测试 push 方法
        System.out.println("测试 push 方法~~");
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "公孙胜", "入云龙");

        HeroNode[] heroNodes = {node1, node2, node3, node4};
        for (HeroNode e : heroNodes) {
            System.out.println("压入栈中的节点：" + e);
            linkedListStack.push(e);
        }

        // 测试 show 方法
        System.out.println("\n测试 show 方法~~");
        System.out.println("当前栈中节点为：（按栈顶到栈底的顺序）");
        linkedListStack.show();

        // 测试 pop 方法
        System.out.println("\n测试 pop 方法~~");

        for (int i = 0; i < 4; i++) {
            HeroNode popNode = linkedListStack.pop();
            System.out.println("压入栈中的节点：" + popNode);
        }

        // 测试 show 方法
        System.out.println("\n测试 show 方法~~");
        System.out.println("当前栈中节点为：（按栈顶到栈底的顺序）");
        try {
            linkedListStack.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
