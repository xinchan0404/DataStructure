package com.xinchan.tree;

/**
 * @author zhengxin
 * @version 1.0.1 2021-11-08
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        // 创建一个二叉树对象，创建时可以不携带根节点，后面可以调用 setRoot 方法设置
        BinaryTree binaryTree = new BinaryTree();

        // 创建树节点
        TreeNode node1 = new TreeNode(1, "宋江");
        TreeNode node2 = new TreeNode(2, "吴用");
        TreeNode node3 = new TreeNode(3, "卢俊义");
        TreeNode node4 = new TreeNode(4, "林冲");
        TreeNode node5 = new TreeNode(5, "关胜");

        // 手动创建二叉树
        binaryTree.setRoot(node1);
        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node3.setLeftNode(node5);
        node3.setRightNode(node4);

        /*
         * 测试前序遍历
         */
        System.out.println("测试前序遍历~~");
        binaryTree.preOrder();

        /*
         * 测试中序遍历
         */
        System.out.println("测试中序遍历~~");
        binaryTree.infixOrder();

        /*
         * 测试后序遍历
         */
        System.out.println("测试后序遍历~~");
        binaryTree.postOrder();

        /*
         * 测试前序遍历查找
         */
        System.out.println("测试前序遍历查找~~");
        TreeNode preOrderSearchNode = binaryTree.preOrderSearch(5);
        System.out.println(preOrderSearchNode);

        /*
         * 测试中序遍历查找
         */
        System.out.println("测试中序遍历查找~~");
        TreeNode infixOrderSearchNode = binaryTree.infixOrderSearch(5);
        System.out.println(infixOrderSearchNode);

        /*
         * 测试后续遍历查找
         */
        System.out.println("测试后续遍历查找~~");
        TreeNode postOrderSearchNode = binaryTree.ppostOrderSearch(5);
        System.out.println(postOrderSearchNode);

        /*
         * 测试删除指定节点
         */
        System.out.println("测试删除指定节点~~");
        System.out.println("删除前，前序遍历~~");
        binaryTree.preOrder();
        boolean res = binaryTree.delNode(5);
        System.out.println("删除后，前序遍历~~");
        binaryTree.preOrder();

        System.out.println("删除" + (res? "成功" : "失败" + "~~"));

        System.out.println(1<<3);
    }
}
