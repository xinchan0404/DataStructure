package com.xinchan.linkedlist;

/**
 * @author zegxn
 * @version 1.0.1 2021-09-24
 */
public class DoubleLinkedList {
    private DoubleHeroNode head = new DoubleHeroNode();


    public DoubleHeroNode getHead() {
        return head;
    }


    public void add(DoubleHeroNode heroNoe) {
        DoubleHeroNode temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNoe);  // 向后链接
        heroNoe.setPre(temp);  // 向前链接
    }


    public void addByOrder(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = head;
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
        if (flag) {
            heroNode.setNext(temp.getNext());
            temp.getNext().setPre(heroNode);
        }
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }


    public void update(DoubleHeroNode heroNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
            return;
        }

        DoubleHeroNode temp = head;
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
            return;
        }

        DoubleHeroNode temp = head;
        boolean flag = false;  // 判定待删除的结点是否存在

        while (temp.getNext() != null) {
            if (temp.getNext().getNo() == no) {
                flag = true;
                temp = temp.getNext();
                break;
            }
            temp = temp.getNext();
        }
        temp.getPre().setNext(temp.getNext());
        if (flag) {
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            } else {
                temp.setPre(null);
            }
        } else {
            System.out.printf("待删除的编号为 %d 的结点不存在，无法删除~~", no);
        }
    }


    /**
     * 查找编号为 no 的结点并返回
     * @param no 待查找结点的编号
     */
    public DoubleHeroNode get(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
            return null;
        }

        DoubleHeroNode temp = head;

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
        DoubleHeroNode temp = head.getNext();

        if (head.getNext() != null) {
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
        DoubleHeroNode temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }
}
