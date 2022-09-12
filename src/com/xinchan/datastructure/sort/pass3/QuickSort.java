package com.xinchan.datastructure.sort.pass3;

import static com.xinchan.datastructure.sort.pass3.Utils.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-09-12
 */
public class QuickSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

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
            swap(arr, i, j);
            if (pivot == arr[j]) {
                i++;
            }
            if (pivot == arr[i]) {
                j--;
            }
        }

        return i;
    }

    private boolean less(int x, int y) {
        return x < y;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
//        int[] arr = new int[] {2, 4, 2, 6, 2};
        int[] arr = randomArray(10000);
        show(arr);
        quickSort.sort(arr);
        show(arr);
        System.out.println("排序成功？: " + isSorted(arr));
    }
}
