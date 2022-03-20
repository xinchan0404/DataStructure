package com.xinchan.datastructure.sort.pass2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-19
 */
class Utils {
    /**
     * 交换数组中指定下标的两个元素
     *
     * @param arr 目标数组
     * @param i   指定下标
     * @param j   指定下标
     */
    static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 判断元素 v 是否严格小于元素 w
     *
     * @param v
     * @param w
     * @return
     */
    static boolean less(int v, int w) {
        return v < w;
    }

    /**
     * 判断数组是否有序
     *
     * @param arr
     * @return 有序返回 true，无序返回 false
     */
    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单行打印数组
     *
     * @param arr
     */
    static void show(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 生成长度为 N 的随机数组
     *
     * @param N 数组长度
     * @return
     */
    static int[] randomArray(int N) {
        int[] arr = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(N + 1);
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
