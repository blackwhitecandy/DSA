package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 复杂链表节点 一个指向下个节点 一个指向随机节点
 * @Date: Create in 9:05 2019/12/17
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
