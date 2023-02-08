package com.xinchan.datastructure.sort.pass5;

import static com.xinchan.datastructure.sort.pass5.Utils.*;

/**
 * @author xinchan
 * @version 1.0.1 2023-02-08
 */
public class MergeSort {
    private int[] auxArr;

    public MergeSort(int n) {
        this.auxArr = new int[n];
    }

    public void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >>> 1;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int left, int right) {
        System.arraycopy(arr, left, auxArr, left, right - left + 1);

        int mid = (left + right) >>> 1, l = left, r = mid + 1;
        for (int k = left; k <= right; k++) {
            if (l > mid) {
                arr[k] = auxArr[r++];
            } else if (r > right) {
                arr[k] = auxArr[l++];
            } else if (less(auxArr[l], auxArr[r])) {
                arr[k] = auxArr[l++];
            } else {
                arr[k] = auxArr[r++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10000);
        MergeSort mergeSort = new MergeSort(10000);

        show(arr);
        mergeSort.mergeSort(arr);
        show(arr);
        System.out.println("排序成功?" + isSorted(arr));
    }
}
