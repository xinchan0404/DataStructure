package com.xinchan.sort.third;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Utils {
    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static boolean compare(int v, int w) {
        return v < w;
    }

    public static void show(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (compare(arr[i + 1], arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static int[] randomArray(int N) {
        int[] arr = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(N + 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,11,13};
        System.out.println(isSorted(arr));
    }
}
