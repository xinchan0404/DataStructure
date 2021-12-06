package com.xinchan.recursion;

/**
 * @author zegxn
 * @version 1.0.1 2021-11-12
 */
public class MazeTest {
    public static void main(String[] args) {
        // 创建迷宫地图
        Maze maze = new Maze();
        maze.createArray();
        System.out.println("原始迷宫地图~~");
        maze.printArray();
        maze.exploreWay(1, 1);
        System.out.println("探测后的迷宫地图~~");
        maze.printArray();
    }
}
