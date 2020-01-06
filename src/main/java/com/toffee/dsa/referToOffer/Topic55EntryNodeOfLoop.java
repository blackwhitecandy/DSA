package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Date: Create in 2019/12/27
 */
public class Topic55EntryNodeOfLoop {
    /**
     * 分两个步骤
     * 1、设置一个快节点一个慢节点，快节点每次走两步，慢节点每次走一步，如果有环的话 最终肯定快节点会追上慢节点
     * 这个时候 快节点走过的路程比慢节点走过的路程刚好是环的整数倍
     * 2、快节点重新从起点开始每次走一步，慢节点从相遇的节点开始走，这个时候两个节点会在入口节点相遇，然后共同到达第一次相遇的节点。
     * 因为慢节点这个时候走的是环的整数倍   快节点走的也是整数倍
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop (ListNode pHead) {
        //如果入口节点为空或者只有一个节点  则返回null
        if (pHead == null || pHead.next == null) {
            return null;
        }
        //设置一个快节点 一个慢节点，快节点每次走两步，慢节点每次走一步。
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //如果没有环的话 最终fast和slow不是同一个节点
        if (fast != slow) {
            return null;
        }

        //快节点从起点出发 每次走一步 慢节点从相遇节点开始 每次走一步 最终会在入口处相遇
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
