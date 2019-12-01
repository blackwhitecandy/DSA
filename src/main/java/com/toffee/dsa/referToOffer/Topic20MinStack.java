package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author glz
 * @Description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * 思路 ： stack必须满足 后劲先出  实现方式有数组和链表两种
 * 数组实现栈需要涉及到扩容的操作 有点麻烦
 * 链表实现比较简单
 * 获取栈中最小元素的时间复杂度是O(1)  所以 必须保存有最小值 而且实时更新
 * @ Date 2019-12-01 下午4:04
 */
public class Topic20MinStack {
    /**
     * 定义节点类
     */
    private class ListNode {
        int node;
        ListNode pre = null;
        ListNode next = null;
        public ListNode(int node) {
            this.node = node;
        }
    }

    //定义链表头元素
    private ListNode head = new ListNode(0);
    //定义链表尾元素
    private ListNode tail = new ListNode(0);
    private int minValue = -1;
    private int nodeNum = 0;//节点数目

    /**
     * 栈的push操作  栈顶添加元素
     * @param node
     */
    public void push(int node) {
        ListNode listNode =  new ListNode(node);
        //如果头元素指向空 则是第一个元素
        if (head.next == null) {
            head.next = listNode;
            tail.pre = listNode;

            //设置最小值
            minValue = node;
        } else {
            //其他情况末尾加上一个新元素
            ListNode pre = tail.pre;
            pre.next = listNode;
            tail.pre = listNode;
            listNode.pre = pre;

            updateMinValue();
        }
        nodeNum++;
    }

    /**
     * 栈的pop操作 栈顶元素移除
     */
    public void pop() {
        if (tail.pre == null) {
            throw new NullPointerException("stack is empty");
        } else {//移除栈顶元素
            ListNode pre = tail.pre;
            //如果最后一个元素的前元素为空 则代表链表只有一个元素
            if (pre.pre == null) {
                head.next = null;
                tail.pre = null;
            } else {
                //弹出最后一个元素 tail指向倒数第二个元素
                tail.pre = pre.pre;
                tail.pre.next = null;//让GC回收最后一个元素
            }

            nodeNum--;
            updateMinValue();
        }
    }

    /**
     * 返回栈顶元素
      * @return
     */
    public int top() {
        if (tail.pre == null) {
            throw new NullPointerException("stack is empty");
        } else {
            return tail.pre.node;
        }
    }

    /**
     * 返回最小值
     * @return
     */
    public int min() {
        if (nodeNum <= 0) {
            throw new NullPointerException("stack is empty");
        }
        return minValue;
    }

    /**
     * 更新stack的最小值
     */
    private void updateMinValue () {
        if (nodeNum <= 0) {
            return ;
        }
        ListNode listNode = head.next;
        minValue = listNode.node;
        do {
            minValue = listNode.node < minValue ? listNode.node : minValue;
            listNode = listNode.next;
        } while (listNode != null);
    }
}
