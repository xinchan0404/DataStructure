package com.xinchan.datastructure.sort.pass3;

import static com.xinchan.datastructure.sort.pass3.Utils.*;

/**
 * 快速排序
 * @author xinchan
 * @version 1.0.1 2022-03-19
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
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
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
        QuickSort quickSort = new QuickSort();
        int[] arr = randomArray(1000);

        quickSort.quickSort(arr);

        System.out.println(isSorted(arr));
    }
}
