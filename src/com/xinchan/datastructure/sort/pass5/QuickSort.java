package com.xinchan.datastructure.sort.pass5;

import static com.xinchan.datastructure.sort.pass5.Utils.*;

/**
 * @author xinchan
 * @version 1.0.1 2023-02-08
 */
public class QuickSort {
    public void quickSort(int[] arr) {
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
        int pivot = arr[(left + right) >>> 1];
        while (left < right) {
            while (less(arr[left], pivot)) {
                left++;
            }
            while (less(pivot, arr[right])) {
                right--;
            }

            if (left >= right) {
                break;
            }

            swap(arr, left, right);

            if (arr[left] == pivot) {
                right--;
            }
            if (arr[right] == pivot) {
                left++;
            }
        }

        return right;
    }

    public static void main(String[] args) {
//        int[] arr = {2,4,2,6,2};
        int[] arr = randomArray(10000);
        QuickSort quickSort = new QuickSort();

        show(arr);
        quickSort.quickSort(arr);
        show(arr);
        System.out.println("排序成功?" + isSorted(arr));
    }
}
