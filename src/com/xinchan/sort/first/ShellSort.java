package com.xinchan.sort.first;

import java.util.Arrays;

import static com.xinchan.sort.first.BubbleSort.createUnsortedArray;

/**
 * 希尔排序
 * @author zhengxin
 * @version 1.0.1 2021-11-20
 */
public class ShellSort {
    public static void main(String[] args) {
        /*
         * 测试希尔排序每一轮运行结果
         */
        System.out.println("----------测试希尔排序每一轮运行结果----------");
        shellSortTest();

        /*
         * 测试希尔排序运行速度
         */
        System.out.println("----------测试希尔排序运行速度----------");
        int[] randomArray = createUnsortedArray(50000);

        System.out.println("希尔排序前：");
//        System.out.println(Arrays.toString(randomArray));
        long startMs = System.currentTimeMillis();
//        shellSort(randomArray);  // 2145 ms
        /*
         * 在随机无序数组情况下，希尔排序相对于直接插入排序没有很大改观，如果待排序数组分布呈逆序形式，会差别很大
         */
        shellSortOptimize(randomArray);  // 169 ms
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("希尔排序后：");
//        System.out.println(Arrays.toString(randomArray));
        System.out.println("耗时：" + timeCost + " ms");
    }

    /**
     * 希尔排序每一轮运行结果
     */
    public static void shellSortTest() {
        // 待排序数组
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int tmp = 0;
        int gap = 0;

        /*
         * 希尔排序第一轮运行结果（交换法）
         */
        gap = 5;
         System.out.println("希尔排序第一轮运行前：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < 5; i++) {
            for (int j = i; j >= 0; j -= gap) {
                if (array[j] > array[j + gap]) {
                    tmp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("希尔排序第一轮运行后：");

        /*
         * 希尔排序第二轮运行结果（交换法）
         */
        gap = gap / 2;  // 每次对数组长度二分
        System.out.println("希尔排序第二轮运行前：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - gap; i++) {
            for (int j = i; j >= 0; j -= gap) {
                if (array[j] > array[j + gap]) {
                    tmp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("希尔排序第二轮运行后：");

        /*
         * 希尔排序第二轮运行结果（交换法）
         */
        gap = gap / 2;  // 每次对数组长度二分
        System.out.println("希尔排序第三轮运行前：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - gap; i++) {
            for (int j = i; j >= 0; j -= gap) {
                if (array[j] > array[j + gap]) {
                    tmp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("希尔排序第三轮运行后：");
    }

    /**
     * 希尔排序
     * @param array 待排序数组
     */
    public static void shellSort(int[] array) {
        if (array == null) {
            System.out.println("数组为空，无法排序~~");
            return;
        }

        int tmp = 0;

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < array.length - gap; i++) {
                for (int j = i; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        tmp = array[j + gap];
                        array[j + gap] = array[j];
                        array[j] = tmp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序（优化）
     * @param array 待排序数组
     */
    public static void shellSortOptimize(int[] array) {
        if (array == null) {
            System.out.println("数组为空，无法排序~~");
            return;
        }

        int tmp = 0;

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = 1; i < array.length; i++) {  // 直接插入排序默认初始第一个数据是有序序列
                int insertIndex = i - 1;
                int insertValue = array[i];

                while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                    array[insertIndex + 1] = array[insertIndex];
                    insertIndex--;
                }

                if (insertIndex != i) {
                    array[insertIndex + 1] = insertValue;
                }
            }
        }
    }
}
