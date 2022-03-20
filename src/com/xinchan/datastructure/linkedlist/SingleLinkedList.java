package com.xinchan.datastructure.linkedlist;

/**
 * 创建一个带头结点的单链表 SingleLinkedList，可以进行增-删-改-查
 * @author zegxn
 * @version 1.0.1 2021-09-22
 */

public class SingleLinkedList {
    // 创建头结点head，头结点不存放数据
    private final HeroNode head = new HeroNode();

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNoe) {
        HeroNode temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNoe);
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;  // 判定待插入的结点位置：最后（一次链接） OR 中间（两次链接）

        while (temp.getNext() != null) {
            if (temp.getNext().getNo() > heroNode.getNo()) {
                flag = true;
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()){
                System.out.println("待添加的英雄编号已经存在");
                break;
            }
            temp = temp.getNext();  // 跟踪标志后移
        }
        try {
            if (flag) {
                heroNode.setNext(temp.getNext());
            }
            temp.setNext(heroNode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(HeroNode heroNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;  // 标志待更新的结点是否存在

        while (temp.getNext() != null) {
            if (temp.getNext().getNo() == heroNode.getNo()) {
                temp = temp.getNext();
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(heroNode.getName());
            temp.setNickname(heroNode.getNickname());
        } else {
            System.out.printf("待更新编号为 %d 的结点不存在，无法修改\n", heroNode.getNo());
        }
    }

    public void delete(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
        }

        HeroNode temp = head;
        boolean flag = false;  // 判定待删除的结点是否存在

        while (temp.getNext() != null) {
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.printf("待删除的编号为 %d 的结点不存在，无法删除~~", no);
        }
    }

    /**
     * 查找编号为 no 的结点并返回
     * @param no 待查找结点的编号
     */
    public HeroNode get(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
            return null;
        }

        HeroNode temp = head;
        boolean flag = false;
        HeroNode getNode = null;

        while (temp.getNext() != null) {
            if (temp.getNext().getNo() == no) {
                return temp.getNext();
            }
            temp = temp.getNext();
        }

        System.out.printf("编号为 %d 的结点不存在\n", no);
        return null;
    }

    public int getLen() {
        int len = 0;  // 链表结点个数
        HeroNode temp = head.getNext();

        if (head.getNext() == null) {
            // 链表为空
        } else {
            while (temp != null) {
                len++;
                temp = temp.getNext();
            }
        }

        return len;
    }

    public void show() {
        // 判断链表是否为空
        if (head.getNext() == null) {
            throw new RuntimeException("链表为空~~");
        }

        // 辅助变量 temp 跟踪当前遍历的位置
        HeroNode temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }
}
