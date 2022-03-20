package com.xinchan.datastructure.recursion;

/**
 * @author zegxn
 * @version 1.0.1 2021-11-12
 */
public class RecursionReview {
    public static void main(String[] args) {
        /*
         * 打印问题
         */
        System.out.println("打印问题~~");
        recursionPrint(5);

        /*
         * 阶乘问题
         */
        System.out.println("阶乘问题~~");
        int res = factorial(5);
        System.out.println("5!=" + res);
    }

    /**
     * 递归实现打印问题
     * @param n
     */
    public static void recursionPrint(int n) {
        if (n > 2) {
            recursionPrint(n - 1);
        }
        System.out.println("n=" + n);
    }

    /**
     * 递归实现阶乘
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
