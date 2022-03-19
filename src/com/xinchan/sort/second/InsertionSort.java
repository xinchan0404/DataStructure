package com.xinchan.sort.second;

import static com.xinchan.sort.second.Utils.*;

/**
 * 插入排序
 * @author xinchan
 * @version 1.0.1 2022-01-19
 */
public class InsertionSort {
    /**
     * 将数组 arr 按照升序排序
     *
     * @param arr 待排序数组
     */
    public void sort(int[] arr) {
        final int N = arr.length;
        for (int i = 1; i < N; i++) {
            int cur = arr[i];
            int pos = i;
            for (int j = i - 1; j >= 0 && less(cur, arr[j]); j--) {
                arr[j + 1] = arr[j];
                pos = j;
            }
            arr[pos] = cur;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();// O(n^2) ~ n^2 / 2
        int[] arr = randomArray(20);

        show(arr);
        insertionSort.sort(arr);
        show(arr);
        System.out.println("排序成功？ " + isSorted(arr));
    }
}
