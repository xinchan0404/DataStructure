package com.xinchan.datastructure.sort.pass4;

import static com.xinchan.datastructure.sort.pass4.Utils.*;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }

    private void adjust(int[] arr, int start, int n) {
        int tmp = arr[start];

        for (int child = 2 * start + 1; child < n; child = 2 * child + 1) {
            if (child + 1 < n && arr[child] < arr[child + 1]) {
                child++;
            }

            if (tmp < arr[child]) {
                arr[start] = arr[child];
                start = child;
            } else {
                break;
            }
        }

        arr[start] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(1000);

        HeapSort heapSort = new HeapSort();

        show(arr);
        heapSort.sort(arr);
        show(arr);
        System.out.println("排序成功?" + isSorted(arr));
    }
}
