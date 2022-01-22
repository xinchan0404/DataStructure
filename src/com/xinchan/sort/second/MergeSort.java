package sort.second;

import static sort.second.Utils.*;

/**
 * 归并排序
 *
 * @author xinchan
 * @version 1.0.1 2022-01-20
 */
public class MergeSort {
    /*
     * instance field
     */
    private int[] auxArr;

    /**
     * 将数组 arr 按照升序排序
     *
     * @param arr
     */
    public void sort(int[] arr) {
        this.auxArr = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 拆分（分） - 将数组拆分到最小单元
     *
     * @param arr
     * @param left
     * @param right
     */
    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >>> 1;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    /**
     * 归并（治） - 将两个有序的子数组合并成一个有序的父数组
     *
     * @param arr
     * @param left
     * @param right
     */
    private void merge(int[] arr, int left, int right) {
        System.arraycopy(arr, left, auxArr, left, right - left + 1);

        int mid = (left + right) >>> 1;
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = auxArr[j++];
            } else if (j > right) {
                arr[k] = auxArr[i++];
            } else if (less(auxArr[j], auxArr[i])) {
                arr[k] = auxArr[j++];
            } else {
                arr[k] = auxArr[i++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] arr = randomArray(1000);
        show(arr);
        mergeSort.sort(arr);
        show(arr);
        System.out.println("排序成功？" + isSorted(arr));
    }
}
