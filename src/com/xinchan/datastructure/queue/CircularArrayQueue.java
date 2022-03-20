package com.xinchan.datastructure.queue;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */
public class CircularArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arrayQueue;


    public CircularArrayQueue() { }

    public CircularArrayQueue(int maxSize) {
        this.maxSize = maxSize;  // 循环队列实际存储空间为 maxSize-1
        this.arrayQueue = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
//        return (rear - front + maxSize) % maxSize == maxSize - 1;
        return (rear + 1) % maxSize == front;
    }

    public void add(int data) {
        if (isFull()) {
            throw new RuntimeException("队列满，不能加入数据~~");
        }

        arrayQueue[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据~~");
        }

        int value = arrayQueue[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据~~");
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arrayQueue[%d]=%d\n", i % maxSize, arrayQueue[i % maxSize]);
        }
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public int headOfQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据~~");
        }

        return arrayQueue[front];
    }
}
