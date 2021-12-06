package com.xinchan.queue;

/**
 * 使用数组模拟队列，构造 ArrayQueue 类
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */


public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arrayQueue;

    public ArrayQueue() {
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arrayQueue = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void add(int data) {
        if (isFull()) {
            throw new RuntimeException("队列满，不能加入数据~~");
        }

        rear++;
        arrayQueue[rear] = data;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据~~");
        }

        front++;
        return arrayQueue[front];
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据~~");
        }

        for (int i = front + 1; i < rear + 1; i++) {
            System.out.printf("arrayQueue[%d]=%d\n", i, arrayQueue[i]);
        }
    }

    public int headOfQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据~~");
        }

        return arrayQueue[front + 1];
    }
}