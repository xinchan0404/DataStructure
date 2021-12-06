package com.xinchan.test.arrayCopy;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-22
 */
public class Clone {
    public static void main(String[] args) {
        int[] scores = new int[] { 100, 81, 68, 75, 91, 66, 75, 100 };

        System.out.println("原数组：");
        System.out.println(Arrays.toString(scores));

        int[] cloneScores = scores.clone();

        System.out.println("克隆数组：");
        System.out.println(Arrays.toString(cloneScores));
    }
}
