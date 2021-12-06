package com.xinchan.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 测试 冒泡排序
 * @author zegxn
 * @version 1.0.1 2021-11-17
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*
         * 测试冒泡排序每一轮结果
         */
        System.out.println("----------测试冒泡排序每一轮结果----------");
        bubbleSortTest();

        /*
         * 测试冒泡排序方法
         */
        System.out.println("----------测试冒泡排序方法----------");
        int[] randomArray = createUnsortedArray(50000);

        System.out.println("冒泡排序前：");
//        System.out.println(Arrays.toString(randomArray));
        long startMs = System.currentTimeMillis();
        bubbleSort(randomArray);  // 3762 ms
//        bubbleSortOptimize(randomArray);  // 3743 ms
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("冒泡排序后：");
//        System.out.println(Arrays.toString(randomArray));
        System.out.println("耗时：" + timeCost + " ms");
    }

    /**
     * 生成指定长度的随机数组
     * @param n 待生成的无序数组的长度
     * @return 返回长度 n 的随机数组
     */
    public static int[] createUnsortedArray(int n) {
        int[] randomArray = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            randomArray[i] = random.nextInt(n + 1);
        }

        return randomArray;
    }

    /**
     * 打印冒泡排序每一轮结果
     */
    public static void bubbleSortTest() {
        // 待排序数组
        int[] array = {9,6,4,-4};

        /*
         * 冒泡排序第一轮
         */
        System.out.println("冒泡排序第一轮前：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        System.out.println("冒泡排序第一轮后：");
        System.out.println(Arrays.toString(array));

        /*
         * 冒泡排序第二轮
         */
        System.out.println("冒泡排序第二轮前：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1 - 1; i++) {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        System.out.println("冒泡排序第二轮后：");
        System.out.println(Arrays.toString(array));

        /*
         * 冒泡排序第三轮
         */
        System.out.println("冒泡排序第三轮前：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1 - 2; i++) {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        System.out.println("冒泡排序第三轮后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 对一个无序数组进行排序冒泡排序
     * @param array 待排序数组
     */
    public static void bubbleSort(int[] array) {
        if (array == null) {
            System.out.println("数组为空，无法排序~~");
            return;
        }

        int tmp = 0;
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 对一个无序数组进行排序冒泡排序（优化）
     * @param array 待排序数组
     */
    public static void bubbleSortOptimize(int[] array) {
        if (array == null) {
            System.out.println("数组为空，无法排序~~");
            return;
        }

        int tmp = 0;
        boolean flag = false;
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            /*
             * 优化思想：如果某次遍历没有调换次序，则说明序列已经有序，应跳出这次循环
             */
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
    }
}
