package com.xinchan.datastructure.test.arrayCopy;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-22
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] srcScores = {100, 81, 68, 75, 91, 66, 75, 100};  // src
        int[] destScores = {80, 82, 71, 92, 68, 71, 87, 88, 81, 79, 90, 77};  // dest

        System.out.println("the src: ");
        System.out.println(Arrays.toString(srcScores));
        System.out.println("the dest: ");
        System.out.println(Arrays.toString(destScores));

        // 将 src 数组中的一部分复制到 dest 数组中
        System.arraycopy(srcScores, 0, destScores, 2, 8);

        System.out.println("the dest after copy: ");
        System.out.println(Arrays.toString(destScores));
    }
}
