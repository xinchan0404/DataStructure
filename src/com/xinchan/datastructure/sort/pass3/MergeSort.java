package com.xinchan.datastructure.sort.pass3;

import static com.xinchan.datastructure.sort.pass3.Utils.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class MergeSort {
    private int[] auxArr;

    public void mergeSort(int[] arr) {
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

        int mid = (left + right) >>> 1;
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                arr[i] = auxArr[r++];
            } else if (r > right) {
                arr[i] = auxArr[l++];
            } else if(less(auxArr[l], auxArr[r])) {
                arr[i] = auxArr[l++];
            } else {
                arr[i] = auxArr[r++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = randomArray(1000);

//        show(arr);
        mergeSort.mergeSort(arr);
//        show(arr);

        System.out.println(isSorted(arr));
    }
}
