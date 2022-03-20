package com.xinchan.datastructure.stack;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-29
 */
public class ArrayStack {
    private int[] arrayStack;
    private int top;
    private int stackSize;


    public ArrayStack(int stackSize) {
        this.arrayStack = new int[stackSize];
        this.top = -1;
        this.stackSize = stackSize;
    }


    public boolean isFull() {
        return top == stackSize - 1;
    }


    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * 入栈
     * @param n 待入栈元素
     */
    public void push(int n) {
        if (isFull()) {
            throw new RuntimeException("栈已满~~");
        }

        top++;
        arrayStack[top] = n;
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空~~");
        }

        int popValue = arrayStack[top];
        top--;
        return popValue;
    }

    /**
     * 遍历栈
     */
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~");
        }

        for (int i = top; i > -1; i--) {
            System.out.printf("%d  ", arrayStack[i]);
        }
    }
}
