package com.xinchan.datastructure.sparsearray;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-18
 */
public class SparseArray {
    public static void main(String[] args) {
        // 0 => 空，1 => 黑色棋子，2 => 白色棋子
        int[][] chessArray1 = new int[11][11];

        // 填充棋子
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[3][3] = 1;

        System.out.println("原始二维数组~~");
        // 输出当前棋盘
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 提取二维数组信息构造稀疏数组
        int dataNum = 0;
        for (int[] row : chessArray1) {
            for (int data : row) {
                if (data != 0) {
                    dataNum++;
                }
            }
        }

        // 构造稀疏数组
        int[][] sparseArray = new int[dataNum + 1][3];

        // 将二维数组转换为稀疏数组
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = dataNum;

        int counter = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    counter++;
                    sparseArray[counter][0] = i;
                    sparseArray[counter][1] = j;
                    sparseArray[counter][2] = chessArray1[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println("稀疏数组~~");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        // 将系数数组 恢复成 二维数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        // 恢复后的二维数组
        System.out.println("恢复后的二维数组~~");
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
