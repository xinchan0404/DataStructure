package com.xinchan.datastructure.test;

import java.util.Random;

/**
 * Java 生成随机数
 * @author zhengxin
 * @version 1.0.1 2021-11-17
 */
public class CreateRandom {
    public static void main(String[] args) {
        /*
         * 基于 Math.random() 方法
         */
        System.out.println("----------基于 Math.random() 方法----------");
        MathRandom();

        /*
         * 测试 Random 类各个方法
         */
        System.out.println("----------测试 Random 类各个方法----------");
        RandomClass();
    }

    /**
     * 基于 Math.random() 方法实现随机生成一个 2~100 偶数
     */
    public static void MathRandom() {
        int min = 2;  // 定义随机数的最小值
        int max = 100;  // 定义随机数的最大值
        // 产生一个 2~100 的数
        int s = (int) min + (int) (Math.random() * (max - min));
        if (s % 2 == 0) {
            // 如果是偶数就输出
            System.out.println("随机数是：" + s);
        } else {
            // 如果是奇数就加1后输出
            System.out.println("随机数是：" + (s + 1));
        }
    }

    public static void RandomClass() {
        Random r = new Random();  // 生成一个 Random 对象
        double d1 = r.nextDouble();  // 生成 [0,1.0) 区间的小数
        double d2 = r.nextDouble() * 7;  // 生成 [0,7.0)区间的小数
        int i1 = r.nextInt(10);  // 生成 [0,10)区间的整数
        int i2 = r.nextInt(18) - 3;  // 生成 [-3,15) 区间的整数
        long l1 = r.nextLong();  // 生成一个随机长整型值
        boolean b1 = r.nextBoolean();  // 生成一个随机布尔型值
        float f1 = r.nextFloat();  // 生成一个随机浮点型值
        System.out.println("生成的 [0,1.0) 区间的小数是：" + d1);
        System.out.println("生成的 [0,7.0) 区间的小数是：" + d2);
        System.out.println("生成的 [0,10) 区间的整数是：" + i1);
        System.out.println("生成的 [-3,15) 区间的整数是：" + i2);
        System.out.println("生成一个随机长整型值：" + l1);
        System.out.println("生成一个随机布尔型值：" + b1);
        System.out.println("生成一个随机浮点型值：" + f1);

        System.out.print("下期七星彩开奖号码预测：");
        for (int i = 1; i < 8; i++) {
            int num = r.nextInt(9); // 生成[0,9)区间的整数
            System.out.print(num);
        }
    }
}
