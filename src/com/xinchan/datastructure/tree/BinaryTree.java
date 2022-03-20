package com.xinchan.datastructure.tree;

/**
 * @author zhengxin
 * @version 1.0.1 2021-11-08
 */
public class BinaryTree {
    // instance field
    private TreeNode root;

    // constructor
    public BinaryTree() {
    }

    // methods
    public TreeNode getRoot() {
        return this.root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /*
     * 前序遍历：根左右
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历~~");
        }
    }

    /*
     * 中序遍历：左根右
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历~~");
        }
    }

    /*
     * 后续遍历：左右根
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历~~");
        }
    }

    /**
     * 前序遍历查找：根左右
     * @param no 待搜索节点的 no
     * @return 如果找到，返回该节点；如果未找到，返回 null
     */
    public TreeNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }

    /**
     * 中序遍历查找：左根右
     * @param no 待搜索节点的 no
     * @return 如果找到，返回该节点；如果未找到，返回 null
     */
    public TreeNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }

    /**
     * 后续遍历查找：根左右
     * @param no 待搜索节点的 no
     * @return 如果找到，返回该节点；如果未找到，返回 null
     */
    public TreeNode ppostOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
            return null;
        }
    }

    /**
     * 按照既定规则，删除指定节点
     * @param no 待删除节点的 no
     * @return 删除成功返回 true，删除失败返回 false
     */
    public boolean delNode(int no) {
        if (root != null) {
            if (root.getNo() != no) {
                return root.delNode(no);
            } else {
                root = null;
                return true;
            }
        } else {
            System.out.println("二叉树为空，无法删除~~");
            return false;
        }
    }
}
