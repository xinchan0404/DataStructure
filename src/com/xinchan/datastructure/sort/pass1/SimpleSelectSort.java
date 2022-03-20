package com.xinchan.datastructure.sort.pass1;

import java.util.Arrays;

import static com.xinchan.datastructure.sort.pass1.BubbleSort.createUnsortedArray;

/**
 * @author zhengxin
 * @version 1.0.1 2021-11-19
 */
public class SimpleSelectSort {
    public static void main(String[] args) {
        /*
         * 测试简单选择排序 每一轮运行结果
         */
        System.out.println("----------测试简单选择排序每一轮运行结果----------");
        simpleSelectSortTest();

        /*
         * 测试简单选择排序
         */
        System.out.println("----------测试简单选择排序----------");
        // 创建待排序数组
        int[] randomArray = createUnsortedArray(50000);

        System.out.println("简单选择排序前：");
//        System.out.println(Arrays.toString(randomArray));
        long startMs = System.currentTimeMillis();
        simpleSelectSort(randomArray);  // 965 ms
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("简单选择排序后：");
//        System.out.println(Arrays.toString(randomArray));
        System.out.println("耗时：" + timeCost + " ms");
    }

    /**
     * 测试简单选择排序每一轮运行结果
     */
    public static void simpleSelectSortTest() {
        // 创建待排序数组
        int[] array = {4, 7, 2, -1};
        int minIndex = 0;
        int tmp = 0;

        /*
         * 简单选择排序第一轮
         */
        System.out.println("简单选择排序第一轮前：");
        System.out.println(Arrays.toString(array));
        minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }

        if (minIndex != 0) {
            tmp = array[minIndex];
            array[minIndex] = array[0];
            array[0] = tmp;
        }
        System.out.println("简单选择排序第一轮后：");
        System.out.println(Arrays.toString(array));

        /*
         * 简单选择排序第二轮
         */
        System.out.println("简单选择排序第二轮前：");
        System.out.println(Arrays.toString(array));
        minIndex = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }

        if (minIndex != 1) {
            tmp = array[minIndex];
            array[minIndex] = array[1];
            array[1] = tmp;
        }
        System.out.println("简单选择排序第二轮后：");
        System.out.println(Arrays.toString(array));

        /*
         * 简单选择排序第三轮
         */
        System.out.println("简单选择排序第三轮前：");
        System.out.println(Arrays.toString(array));
        minIndex = 2;
        for (int i = 3; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }

        if (minIndex != 2) {
            tmp = array[minIndex];
            array[minIndex] = array[2];
            array[2] = tmp;
        }
        System.out.println("简单选择排序第三轮后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 简单选择排序
     * @param array 待排序数组
     */
    public static void simpleSelectSort(int[] array) {
        if (array == null) {
            System.out.println("数组为空，无法排序~~");
            return;
        }

        int minIndex = 0;
        int tmp = 0;

        for (int i = 0; i < array.length; i++) {
            minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                tmp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }
    }
}
