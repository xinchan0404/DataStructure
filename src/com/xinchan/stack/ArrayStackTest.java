package com.xinchan.stack;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-29
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(6);

        // 测试 push 方法
        System.out.println("测试 push 方法~~");
        try {
            for (int i = 0; i < 7; i++) {
                arrayStack.push(i);
                System.out.println("压入栈中的数据：" + i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n测试 show 方法~~");
        System.out.println("当前栈中存在的数据：(从栈顶到栈底)");
        try {
            arrayStack.show();
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 pop 方法
        System.out.println("\n测试 pop 方法~~");
        try {
            for (int i = 0; i < 8; i++) {
                int popValue;
                popValue = arrayStack.pop();
                System.out.println("从栈中弹出数据：" + popValue);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 测试 show 方法
        System.out.println("\n测试 show 方法~~");
        System.out.println("当前栈中存在的数据：(从栈顶到栈底)");
        try {
            arrayStack.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
