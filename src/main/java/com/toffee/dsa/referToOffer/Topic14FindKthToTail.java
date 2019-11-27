package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * @Date: Create in 10:28 2019/11/27
 */
public class Topic14FindKthToTail {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        //findKthToTailArray(listNode1, -1);
        //findKthToTailArray(null, -1);
        //findKthToTailArray(listNode1, 5);
        findKthToTailArray(listNode1, 0);
    }

    /**
     * 最简单思路 算出来链表的长度length 然后再遍历一遍 求第length - k + 1的值
     *
     * @param head
     * @return
     */
    public static ListNode findKthToTailArray(ListNode head, int k) {
        ListNode listNode = head;
        if (head == null) {
            return null;
        }
        if (k < 1) {
            return null;
        }
        int length = 0;
        //计算链表的长度
        do {
            length++;
        } while ((head = head.next) != null);
        if (k > length) {
            return null;
        }
        int index = length - k + 1;//计算正排序要获取的下标
        while (index-- > 1) {
            listNode = listNode.next;
        }
        return listNode;
    }





    /**
     * 链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a?f=discussion
     *     来源：牛客网
     * 时间复杂度O(n),一次遍历即可
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre = null, p = null;
        //两个指针都指向头结点
        p = head;
        pre = head;
        //记录k值
        int a = k;
        //记录节点的个数
        int count = 0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while (p != null) {
            p = p.next;
            count++;
            if (k < 1) {
                pre = pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < a) return null;
        return pre;

    }
}
