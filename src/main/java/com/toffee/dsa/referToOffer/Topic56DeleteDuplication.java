package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Date: Create in 2020/1/6
 */
public class Topic56DeleteDuplication {
    public ListNode deleteDuplication (ListNode pHead) {
        //如果链表为空  或者只有一个节点 直接返回
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //判断开始的元素 是否值相同    相同的话 就除去相同的元素
        if (pHead.val == pHead.next.val) {
            while (pHead.next != null && pHead.val == pHead.next.val) {
                pHead = pHead.next;
            }
            pHead = pHead.next;
        }
        //如果剩余链表为空  或者只有一个节点 直接返回
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        //判断是否有头结点
        boolean hasHead = false;
        ListNode headNode = null;

        ListNode prev = null;
        ListNode current = pHead;
        //如果有下个节点就循环遍历
        while (current != null && current.next != null) {
            //如果当前节点和下个节点值不相同，则prev指向当前节点，当前节点current后移一位
            if (current.val != current.next.val) {
                prev = current;
                current = current.next;
                if (!hasHead) {
                    hasHead = true;
                    headNode = prev;
                }
            } else {
                //如果当前节点和下个节点值相同 则往后遍历找到第一个不相同的元素
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // 让current指向这个元素
                current = current.next;
                //如果prev不为null 让prev的next指针指向当前元素 跳过之前重复的元素
                if (prev != null) {
                    prev.next = current;
                }
            }
        }
        return headNode;
    }
}
