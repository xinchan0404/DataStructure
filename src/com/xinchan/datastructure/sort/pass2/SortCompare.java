package com.xinchan.datastructure.sort.pass2;

import static com.xinchan.datastructure.sort.pass2.Utils.randomArray;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-19
 */
public class SortCompare {
    /**
     * 调用一次排序算法耗时
     *
     * @param alg 排序算法
     * @return 排序耗时
     */
    public static double time(String alg, int[] arr) {
        long startMs = System.currentTimeMillis();
        if (alg.equals("Selection")) {
            new SelectionSort().sort(arr);
        }
        if (alg.equals("Insertion")) {
            new InsertionSort().sort(arr);
        }
        if (alg.equals("Shell")) {
            new ShellSort().sort(arr);
        }
        if (alg.equals("Merge")) {
            new MergeSort().sort(arr);
        }
        return System.currentTimeMillis() - startMs;
    }

    /**
     * 使用算法 alg 将 T 个长度为 N 的数组排序
     *
     * @param alg 排序算法
     * @param N   数组长度
     * @param T   迭代次数
     * @return
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        for (int i = 0; i < T; i++) {
            int[] arr = randomArray(N);
            total += time(alg, arr);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        System.out.println(alg1 + "\nelapsed time: " + t1 + " ms");
        System.out.println(alg2 + "\nelapsed time: " + t2 + " ms");
//        System.out.printf("For %d random Integers\n %s is", N, alg1);
//        System.out.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
