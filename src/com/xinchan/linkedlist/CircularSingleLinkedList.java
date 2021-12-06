package com.xinchan.linkedlist;

/**
 * @author zhengxin
 * @version 1.0.1 2021-09-27
 */
public class CircularSingleLinkedList {
    private Node first;


    public CircularSingleLinkedList() {
    }


    public void init(int nums) {
        // 形参校验
        if (nums < 1) {
            throw new RuntimeException("参数 " + nums + " 错误~~");
        }

        Node curNode = null;  // 创建辅助节点，便于索引
        for (int i = 1; i <= nums; i++) {
            Node newNode = new Node(i);

            if (i == 1) {
                first = newNode;
                first.setNext(first);  // 自己指向自己，为形成环形链表
                curNode = first;
            }

            if (nums > 1){
                curNode.setNext(newNode);
                newNode.setNext(first);
                curNode = curNode.getNext();
            }
        }
        System.out.println("单向环形链表初始化成功~~");
    }

    /**
     * 默认添加方式，在 first 后的第一个位置添加
     * @param node 待添加的节点
     */
    public void add(Node node) {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空~~");
            return;
        }

        Node curNode = first;  // 辅助节点，便于索引
        while (true) {
            if (curNode.getNo() == node.getNo()) {
                System.out.println("待添加的编号为 " + node.getNo() + " 的节点已经存在~~");
                return;
            }

            if (curNode.getNext() == first) {
                break;
            }

            curNode = curNode.getNext();
        }

        node.setNext(first);
        curNode.setNext(node);
    }


    /**
     * 按照节点序号进行添加，
     * @param node 待添加的节点
     */
    public void addByOrder(Node node) {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空~~");
            return;
        }

        // 节点编号是否合法
        if (node.getNo() < 1) {
            System.out.println("节点编号 " + node.getNo() + " 不合法~~");
            return;
        }

        Node curNode = first;  // 辅助节点，便于索引
        while (true) {
            if (curNode.getNo() == node.getNo()) {
                System.out.println("待添加的编号为 " + node.getNo() + " 的节点已经存在~~");
                return;
            }

            if (curNode.getNext().getNo() > node.getNo() || curNode.getNext() == first) {
                break;
            }

            curNode = curNode.getNext();
        }

        node.setNext(curNode.getNext());
        curNode.setNext(node);
    }


    public int size() {
        int size = 0;

        Node curNode = first;
        // 判断链表是否为空
        if (first != null) {
            while (true) {
                size += 1;
                if (curNode.getNext() == first) {
                    break;
                }

                curNode = curNode.getNext();
            }
        }

        return size;
    }

    /**
     * 节点出单向循环列表
     * @param startNo 从第几个节点开始数
     * @param countNum 每次数几下
     */
    public int[] remove(int startNo, int countNum) {
        // 判断链表是否为空
        if (first == null) {
            throw new RuntimeException("参数错误~~");
        }

        // 数据校验
        if (startNo < 1 || startNo > size() || countNum < 2) {
            throw new RuntimeException("参数错误~~");
        }

        // startNode 移动至起始节点位置
        Node startNode = first;
        int tmpStartNo = startNo - 1;
        while (tmpStartNo != 0) {
            tmpStartNo -= 1;
            startNode = startNode.getNext();
        }

        int[] removeSort = new int[size()];
        // 开始出单向循环链表

        Node curNode = startNode;
        int idx = 0;
        while (true) {
            if (curNode.getNext() == curNode) {
                removeSort[idx] = curNode.getNo();
                curNode.setNext(null);
                first = null;
                return removeSort;
            }
            int tmpCountNo = countNum - 1;
            while (tmpCountNo != 1) {
                tmpCountNo -= 1;
                curNode = curNode.getNext();
            }
            removeSort[idx] = curNode.getNext().getNo();
            idx += 1;
            curNode.setNext(curNode.getNext().getNext());
            curNode = curNode.getNext();
        }
    }

    public void show() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空~~");
            return;
        }

        // 只有一个节点
        if (first.getNext() == first) {
            System.out.println(first);
            return;
        }

        // 感觉这种写法好像更简单
        Node curNode = first;
        while (true) {
            System.out.println(curNode);
            if (curNode.getNext() == first) {
                break;
            }
            curNode = curNode.getNext();  // 后移
        }
    }
}
