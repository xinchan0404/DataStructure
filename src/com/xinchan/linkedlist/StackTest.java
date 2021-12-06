package com.xinchan.linkedlist;

import java.util.Stack;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-23
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        // 入栈
        stack.push("zheng");
        stack.push("xin");
        stack.push("wu");

        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
