package com.xinchan.datastructure.sort.pass4;

import static com.xinchan.datastructure.sort.pass4.Utils.*;

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
        int[] arr = randomArray(1000);

        QuickSort quickSOrt = new QuickSort();

        show(arr);
        quickSOrt.sort(arr);
        show(arr);
        System.out.println("排序成功?" + isSorted(arr));
    }
}
