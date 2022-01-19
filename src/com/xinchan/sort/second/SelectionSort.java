package sort.second;

import static sort.second.Utils.*;

/**
 * 选择排序
 *
 * @author xinchan
 * @version 1.0.1 2022-01-19
 */
public class SelectionSort {
    /**
     * 将数组 arr 按照升序排序
     *
     * @param arr 待排序数组
     */
    public void sort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            if (i != min) {
                exch(arr, i, min);
            }
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();  // O(n^2) ~ n^2 / 2
        int[] arr = randomArray(20);

        show(arr);
        selectionSort.sort(arr);
        show(arr);
        System.out.println("排序成功？ " + isSorted(arr));
    }
}
