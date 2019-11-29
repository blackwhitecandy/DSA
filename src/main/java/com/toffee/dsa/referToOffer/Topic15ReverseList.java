package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 输入一个链表，反转链表后，输出新链表的表头。
 * @ Date 2019-11-27 下午9:36
 */
public class Topic15ReverseList {

    public static void main (String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode tail = reverseList(listNode4);
        do {
            System.out.println(tail.val);
            tail = tail.next;
        } while (tail.next != null);
    }
    /**
     * 最简单思路 再构造一个反转的链表
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        //头节点为空 直接返回null
        if (head == null) {
            return null;
        } else if (head.next != null) {
            //如果头节点有下个节点 则遍历设置后节点指向前节点
            ListNode tail = new ListNode(0);//构造尾节点
            ListNode listNodeNext = reverseList(head.next, tail);//获取第二个节点
            listNodeNext.next = head;//让第二个节点指向头节点
            head.next = null;//让头节点指向空  因为反转后头节点是最后一个节点
            return tail;//返回尾节点
        } else {
            //只有头节点的情况 直接返回
            return head;
        }
    }

    /**
     * 遍历列表节点让后一个节点指向前一个 并给尾节点设值
     * @param listNode
     * @param tail
     * @return
     */
    public static ListNode reverseList(ListNode listNode, ListNode tail) {
        if (listNode.next == null) {
            //遍历到最后一个节点的时候 给尾节点设值
            tail.val = listNode.val;
        } else {
            //继续便利 获取下个节点
            ListNode listNodeNext = reverseList(listNode.next, tail);
            listNodeNext.next = listNode;//让下个节点指向当前节点
            //如果尾节点指向为空  则指向当前节点 也就是倒数第二个节点
            if (tail.next == null) {
                tail.next = listNode;
            }
            //当前节点指向null
            //listNode.next = null;
        }

        return listNode;

    }

    /** https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca?f=discussion
     * 来源 牛客网
     * nice code
     * @param head
     * @return
     */
    public ListNode reverseListNice(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
