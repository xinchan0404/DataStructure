package com.xinchan.datastructure.queue;

import java.util.Scanner;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */
public class CircularArrayQueueTest {
    public static void main(String[] args) {
        CircularArrayQueue circularArrayQueue = new CircularArrayQueue(4);  // 循环队列实际存储空间为 3

        boolean loop = true;
        char key = ' ';

        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中获取数据");
            System.out.println("h(head)：显示队列头数据");
            System.out.println("e(exit)：退出程序");

            Scanner in = new Scanner(System.in);
            key = in.next().charAt(0);

            switch (key) {
                case 's':
                    try {
                        circularArrayQueue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数：");
                        int value = in.nextInt();
                        circularArrayQueue.add(value);
                        System.out.println("数据添加成功~~");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int value = circularArrayQueue.get();
                        System.out.printf("获取的数据是 %d\n", value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int value = circularArrayQueue.headOfQueue();
                        System.out.printf("队列头数据是 %d\n", value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    in.close();
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
