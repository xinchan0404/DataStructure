package com.xinchan.datastructure.sort.pass3;

import static com.xinchan.datastructure.sort.pass3.Utils.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-09-13
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
//        int[] arr = {2,4,2,6,2};
        int[] arr = randomArray(10000);
        QuickSort quickSort1 = new QuickSort();

        show(arr);
        quickSort1.sort(arr);
        show(arr);
        System.out.println("排序成功?" + isSorted(arr));
    }
}
