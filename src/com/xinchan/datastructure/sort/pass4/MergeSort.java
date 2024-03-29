package com.xinchan.datastructure.sort.pass4;

import static com.xinchan.datastructure.sort.pass4.Utils.*;

public class MergeSort {
    private int[] auxArr;

    public void sort(int[] arr) {
        this.auxArr = new int[arr.length];
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

        int mid = (left + right) >>> 1, i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = auxArr[j++];
            } else if (j > right) {
                arr[k] = auxArr[i++];
            } else if (auxArr[i] < auxArr[j]) {
                arr[k] = auxArr[i++];
            } else {
                arr[k] = auxArr[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(1000);

        MergeSort mergeSort = new MergeSort();

        show(arr);
        mergeSort.sort(arr);
        show(arr);
        System.out.println("排序成功?" + isSorted(arr));
    }
}
