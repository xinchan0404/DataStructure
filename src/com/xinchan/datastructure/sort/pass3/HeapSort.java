package com.xinchan.datastructure.sort.pass3;

import static com.xinchan.datastructure.sort.pass3.Utils.*;

/**
 * 堆排序
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class HeapSort {
    public void heapSort(int[] arr) {
        for (int father = arr.length / 2 - 1; father >= 0; father--) {
            adjustHeap(arr, father, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private void adjustHeap(int[] arr, int father, int length) {
        int tmp = arr[father];
        for (int child = 2 * father + 1; child < length; child = 2 * child + 1) {
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }
            if (less(tmp, arr[child])) {
                arr[father] = arr[child];
                father = child;
            } else {
                break;
            }
        }
        arr[father] = tmp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = randomArray(1000);

//        show(arr);
        heapSort.heapSort(arr);
//        show(arr);

        System.out.println(isSorted(arr));
    }
}
