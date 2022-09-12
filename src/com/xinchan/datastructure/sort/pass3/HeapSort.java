package com.xinchan.datastructure.sort.pass3;

import static com.xinchan.datastructure.sort.pass3.Utils.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-09-12
 */
public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private void adjustHeap(int[] arr, int i, int n) {
        int tmp = arr[i];

        for (int child = 2 * i + 1; child < n; child = 2 * child + 1) {
            if (child + 1 < n && arr[child] < arr[child + 1]) {
                child++;
            }
            if (less(tmp, arr[child])) {
                arr[i] = arr[child];
                i = child;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
//        int[] arr = new int[] {2,3,6,4,7,3};
        int[] arr = randomArray(10000);

        show(arr);
        heapSort.sort(arr);
        show(arr);
        System.out.println("排序成功?" + isSorted(arr));
    }
}
