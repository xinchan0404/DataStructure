package com.xinchan.datastructure.tree;

/**
 * @author zhengxin
 * @version 1.0.1 2021-11-08
 */
public class TreeNode {
    // instance field
    private int no;
    private String name;
    TreeNode leftNode;
    TreeNode rightNode;

    // constructor

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
        this.leftNode = null;
        this.rightNode = null;
    }

    // methods
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    /**
     * 前序遍历：根左右
     */
    public void preOrder() {
        // 访问当前节点
        System.out.println(this);
        // 如果当前节点的左子节点非空，递归前序遍历
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        // 如果当前节点的右子节点非空，递归前序遍历
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    /**
     * 中序遍历：左根右
     */
    public void infixOrder() {
        // 如果当前节点的左子节点非空，递归中序遍历
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        // 访问当前节点
        System.out.println(this);
        // 如果当前节点的右子节点非空，递归中序遍历
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    /**
     * 后续遍历：左右根
     */
    public void postOrder() {
        // 如果当前节点的左子节点非空，递归后续遍历
        if (this.leftNode != null) {
            this.leftNode.postOrder();
        }
        // 如果当前节点的右子节点非空，递归后续遍历
        if (this.rightNode != null) {
            this.rightNode.postOrder();
        }
        // 访问当前节点
        System.out.println(this);
    }

    /**
     * 前序遍历查找：根左右
     * @param no 待搜索节点的 no
     * @return 如果找到，返回该节点；如果未找到，返回 null
     */
    public TreeNode preOrderSearch(int no) {
        // 如果当前节点为搜索节点，返回当前节点
        if (this.no == no) {
            return this;
        }
        TreeNode resultNode = null;
        // 如果当前节点的左子节点非空，递归前序遍历查找
        if (this.leftNode != null) {
            resultNode = this.leftNode.preOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 如果当前节点的右子节点非空，递归前序遍历查找
        if (this.rightNode != null) {
            resultNode = this.rightNode.preOrderSearch(no);
        }
        return resultNode;
    }

    /**
     * 中序遍历查找：左根右
     * @param no 待搜索节点的 no
     * @return 如果找到，返回该节点；如果未找到，返回 null
     */
    public TreeNode infixOrderSearch(int no) {
        TreeNode resultNode = null;
        // 如果当前节点的左子节点非空，递归中序遍历查找
        if (this.leftNode != null) {
            resultNode = this.leftNode.infixOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 如果当前节点为待搜索节点，返回当前节点
        if (this.no == no) {
            return this;
        }
        // 如果当前节点的右子节点非空，递归中序遍历查找
        if (this.rightNode != null) {
            resultNode = this.rightNode.infixOrderSearch(no);
        }
        return resultNode;
    }

    /**
     * 后续遍历查找：左右根
     * @param no 待搜索节点的 no
     * @return 如果找到，返回该节点；如果未找到，返回 null
     */
    public TreeNode postOrderSearch(int no) {
        TreeNode resultNode = null;
        // 如果当前节点的左子节点非空，递归后序遍历查找
        if (this.leftNode != null) {
            resultNode = this.leftNode.postOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 如果当前节点的右子节点非空，递归后续遍历查找
        if (this.rightNode != null) {
            resultNode = this.rightNode.postOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 如果当前节点为待搜索节点，返回当前节点
        if (this.no == no) {
            return this;
        }

        return null;
    }

    /**
     * 按照既定规则，删除二叉树中的指定节点
     * 规则：如果待删除的节点是叶子节点，则删除该叶子节点
     *      如果待删除的节点非叶子节点，则删除以该叶子节点为根节点的子树
     * @param no 指定删除节点的 no
     * @return 删除成功返回 true，删除失败返回 false
     */
    public boolean delNode(int no) {
        boolean res = false;
        // 如果当前节点的左子节点非空，执行下述步骤
        if (this.leftNode != null) {
            // 如果当前节点的左子节点不是待删除节点，则递归删除当前节点的左子节点
            // 如果当前节点的左子节点是待删除节点，则直接删除并且结束递归删除
            if (this.leftNode.no != no) {
                res = this.leftNode.delNode(no);
                if (res) {
                    return true;
                }
            } else {
                this.leftNode = null;
                return true;
            }
        }
        // 如果当前节点的右子节点非空，执行下述步骤
        if (this.rightNode != null) {
            // 如果当前节点的右子节点不是待删除节点，则递归删除当前节点的右子节点
            // 如果当前节点的右子节点是待删除节点，则直接删除并结束递归删除
            if (this.rightNode.no != no) {
                res = this.rightNode.delNode(no);
                return res;
            } else {
                this.rightNode = null;
                return true;
            }
        }

        return false;
    }

//    /**
//     * 按照既定规则，删除二叉树中的指定节点
//     * 规则：如果待删除的是叶子节点，则删除该节点
//     *      如果待删除的节点非叶子节点：
//     *          如果该非叶子节点只有一个子节点（左子节点或者右子节点），则由子节点代替待删除节点
//     *          如果该非叶子节点有两个子节点（左子节点和右子节点），则由左子节点代替待删除结点
//     * @param name 待删除节点的名字
//     * @return 删除成功返回 true，删除失败返回 false
//     */
//    public boolean delNode1(String name) {
//        boolean res = false;
//        if (this.leftNode != null) {
//            if (!this.leftNode.name.equals(name)) {
//                res = this.leftNode.delNode1(name);
//                if (res) {
//                    return res;
//                }
//            } else {
//                if (this.leftNode.leftNode == null && this.leftNode.rightNode == null) {
//                    this.leftNode = null;
//                    return true;
//                } else if (this.leftNode.leftNode != null && this.leftNode.rightNode != null) {
//                    this.leftNode.rightNode = this.rightNode;
//                } else {
//                    this.
//                }
//            }
//        }
//    }
}
