package com.toffee.dsa.referToOffer;

import java.util.Stack;
import java.util.Vector;

/**
 * @Author: glz
 * @Description: 输入两个链表，找出它们的第一个公共结点。
 * @Date: Create in 2019/12/20
 */
public class Topic36FindFirstCommonNode {
    /**
     * 用栈分别存储两个链表中的节点再同时pop，比较是否相等
     * 这种处理方式 没办法处理循环链表 姑且认为是单链表
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //定义两个栈  分别把两个链表各自入栈
        Stack<ListNode> listNodeStack1 = new Stack<>();
        Stack<ListNode> listNodeStack2 = new Stack<>();
        while (pHead1 != null) {
            listNodeStack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            listNodeStack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        //通过pop操作判断相同的节点
        ListNode commonNode = listNodeStack1.peek();
        //pop遍历栈 找到最后一个相同的节点
        while (listNodeStack1 != null && listNodeStack2 != null) {
            if (listNodeStack1.peek() == listNodeStack2.pop()) {
                commonNode = listNodeStack1.pop();
            } else {
                break;
            }
        }
        return commonNode;
    }

    /**
     * 特殊标记法 只能处理单链表
     * 标记链表1每个节点都指向自己 遍历链表2的时候 找到第一个指向自己的元素就是第一个公共的节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode getFirstCommonNode2(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode currentNode1 = pHead1;
        while (pHead1 != null) {
            //当前节点
            currentNode1 = pHead1;
            //让phead1指向下个节点
            pHead1 = pHead1.next;
            //让当前节点指向自己
            currentNode1.next = currentNode1;
        }
        //遍历pHead2 找到第一个指向自己的节点 就是相同的 否则就没有相同节点
        while (pHead2 != null) {
            if (pHead2 == pHead2.next) {
                return pHead2;
            }
            //让phead2指向下个节点
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 牛客网
     * 用两个指针扫描”两个链表“，最终两个指针到达 null 或者到达公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode getFirstCommonNode3(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        while(pHead1 != pHead2) {
            pHead1 = (pHead1 == null ? pHead2 : pHead1.next);
            pHead2 = (pHead2 == null ? pHead1 : pHead2.next);
        }
        return pHead1;
    }

    /**
     * 两个链表有交点 肯定有公共尾部
     * 思路 获取两个链表的长度差，让较长的链表 先走差值步，然后再同时走，找到第一个相同的节点，不存在返回null
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode getFirstCommonNode4(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        while(pHead1 != pHead2) {
            pHead1 = (pHead1 == null ? pHead2 : pHead1.next);
            pHead2 = (pHead2 == null ? pHead1 : pHead2.next);
        }
        return pHead1;
    }
}
