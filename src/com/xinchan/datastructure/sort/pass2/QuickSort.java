package com.xinchan.datastructure.sort.pass2;

import static com.xinchan.datastructure.sort.pass2.Utils.*;

/**
 * 快速排序
 *
 * @author xinchan
 * @version 1.0.1 2022-01-21
 */
public class QuickSort {
    /**
     * 将数组 arr 按照升序排序
     *
     * @param arr
     */
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 用于递归调用的排序方法
     *
     * @param arr
     * @param left
     * @param right
     */
    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    /**
     * 对大数组进行切分
     *
     * @param arr
     * @param left
     * @param right
     */
    private int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[(left + right) >>> 1];
        while (i < j) {
            while (less(arr[i], pivot)) {
                i++;
            }
            while (less(pivot, arr[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
            /*
             * 因为 i, j 的变化是要求严格大于或小于才会变化的
             * 需要对索引值等于 pivot 的情况单独考虑的，防止两端都等于 pivot 时，陷入死循环
             */
            if (arr[i] == pivot) {
                j--;
            }
            if (arr[j] == pivot) {
                i++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

//        int[] arr = {9, 9, 2, 5, 4, 8, 10, 6, 1, 10};
        int[] arr = {1,1,2,3,1};
//        int[] arr = randomArray(100);
        show(arr);
        quickSort.sort(arr);
        show(arr);
        System.out.println("排序成功？" + isSorted(arr));
    }
}
