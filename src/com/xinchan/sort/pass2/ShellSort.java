package com.xinchan.sort.pass2;

import static com.xinchan.sort.pass2.Utils.*;

/**
 * 希尔排序
 *
 * @author xinchan
 * @version 1.0.1 2022-01-19
 */
public class ShellSort {
    /**
     * 将数组 arr 按照升序排序
     *
     * @param arr 待排序数组
     */
    public void sort(int[] arr) {
        int N = arr.length;
        for (int incr = N / 2; incr > 0; incr /= 2) {
            for (int j = incr; j < N; j++) {
                int pos = j;
                int cur = arr[j];
                for (int k = j - incr; k >= 0 && less(cur, arr[k]); k -= incr) {
                    arr[k + incr] = arr[k];
                    pos = k;
                }
                if (pos != j) {
                    arr[pos] = cur;
                }
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = randomArray(101);

        show(arr);
        shellSort.sort(arr);
        show(arr);
        System.out.println("排序成功？" + isSorted(arr));
    }
}
