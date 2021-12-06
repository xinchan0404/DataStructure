package com.xinchan.test.arrayCopy;

import java.util.Arrays;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-22
 */
public class CopyOfRange {
    public static void main(String[] args) {
        // 定义长度为 5 的数组
        int[] scores = {57, 81, 68, 75, 91, 66, 75, 84};

        System.out.println("the original 内容如下：");
        System.out.println(Arrays.toString(scores));

        // 定义一个新的数组，将 scores 数组中的第 2-8 个元素复制过来
        // 同时留 2 个内存空间供以后开发使用
        int[] copyScores = Arrays.copyOfRange(scores, 2, 10);

        System.out.println("the copy 内容如下：");
        System.out.println(Arrays.toString(copyScores));
    }
}
