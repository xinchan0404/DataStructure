package com.xinchan.datastructure.recursion;

/**
 * @author zegxn
 * @version 1.0.1 2021-11-12
 */
public class Maze {
    // instance field
    private int[][] mazeArray;  // 迷宫地图

    // constructor
    public Maze() {
        this.mazeArray = new int[10][10];
    }

    // methods

    /**
     * 初始化迷宫地图
     */
    public void createArray() {
        for (int i = 0; i < 10; i++) {
            mazeArray[0][i] = 1;
            mazeArray[9][i] = 1;
        }

        for (int i = 0; i < 10; i++) {
            mazeArray[i][0] = 1;
            mazeArray[i][9] = 1;
        }

        for (int i = 1; i < 5; i++) {
            mazeArray[3][i] = 1;
        }

        /*
         * 目前这个版本的程序，加上这堵墙无法走通
         */
//        for (int i = 5; i < 9; i++) {
//            mazeArray[i][6] = 1;
//        }

        for (int i = 0; i < 7; i++) {
            mazeArray[7][i] = 1;
        }

        for (int i = 3; i < 9; i++) {
            mazeArray[1][i] = 1;
        }
    }

    /**
     * 打印当前迷宫地图
     */
    public void printArray() {
        System.out.println("迷宫地图~~");
        for (int[] ints : mazeArray) {
            for (int data: ints) {
                System.out.printf("%-4d", data);
            }
            System.out.println();
        }
    }

    /**
     * 探测迷宫是否能走通
     * 规则：迷宫地图共有四种标记：0 没走过；1 墙；2 已经走过，可以走通；3 已经走过，无法走通
     * 策略：下 -> 右 -> 上 -> 左
     */
    /**
     * 探测迷宫是否能走通
     * 规则：迷宫地图共有四种标记：0 没走过；1 墙；2 已经走过，可以走通；3 已经走过，无法走通
     * 策略：下 -> 右 -> 上 -> 左
     * @param i 当前位置横坐标
     * @param j 当前位置纵坐标
     * @return 存在到达目标点通路返回 true；不存在到达目标点通路返回 false
     */
    public boolean exploreWay(int i, int j) {
        if (mazeArray[8][8] == 2) {  // 是否已经到达，递归结束标志
            return true;
        } else {
            if (mazeArray[i][j] == 0) {
                mazeArray[i][j] = 2;
                // 如果当前位置标志为 0，按照既定策略进行探测
                if (exploreWay(i+1, j)) {  // 下
                    return true;
                } else if (exploreWay(i, j+1)) {  // 右
                    return true;
                } else if (exploreWay(i-1, j)) {  // 上
                    return true;
                } else if (exploreWay(i, j-1)) {  // 左
                    return true;
                } else {
                    mazeArray[i][j] = 3;  // 当前位置无法走通，修改标志为 3
                    return false;
                }
            } else {
                return false;  // 如果当前位置标志为 1、2、3，返回 false
            }
        }
    }
}
