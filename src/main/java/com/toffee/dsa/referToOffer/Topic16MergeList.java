package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Date: Create in 11:13 2019/11/28
 */
public class Topic16MergeList {

    public static void main (String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode21 = new ListNode(2);
        ListNode listNode31 = new ListNode(3);
        ListNode listNode41 = new ListNode(4);
        listNode11.next = listNode21;
        listNode21.next = listNode31;
        listNode31.next = listNode41;

        ListNode listNode = merge(listNode1, listNode11);
        System.out.println(listNode.val);
    }
    /**
     * 设置一个头结点   交替循环两个链表 判断大小 让头结点 依次指向其他节点
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge (ListNode list1,ListNode list2) {
        //异常情况 判断 判断list1 和 list2  是否为空
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }

        ListNode headNode;//新链表的头结点 并给头结点赋值
        if (list1.val <= list2.val) {
            headNode = list1;
            list1 = list1.next;
        } else {
            headNode = list2;
            list2 = list2.next;
        }
        ListNode head = headNode;//备份头结点  作为返回值

        //判断list1 和 list2  是否为null
        while (list1 != null && list2 != null) {
            //遍历如果当前list1不为空 且当前值 小于等于list2的值 则给头结点赋值 list1后移
            while (list1 != null && list1.val <= list2.val) {
                headNode.next = list1;//头结点赋值
                headNode = headNode.next;//头结点后移
                list1 = list1.next;//链表1后移  直到找到一个值大于链表2的值
            }
            //如果链表1  先遍历完了 则  整个遍历结束 否则进行下面的遍历
            if (list1 == null) {
                break;
            }
            //遍历如果当前list2不为空 且当前值 小于list1的值 则给头结点赋值 list2后移
            while (list2 != null && list1.val > list2.val){
                headNode.next = list2;//头结点指向新节点
                headNode = headNode.next;//头结点后移
                list2 = list2.next;//链表2后移  直到找到一个值大于等于 链表1的值
            }
        }
        //链表一先遍历完的话 依次让头结点指向链表2剩余的节点   链表2同样的操作
        if (list1 == null) {
            do {
                headNode.next = list2;
                headNode = headNode.next;
            } while ((list2 = list2.next) != null);
        } else {
            do {
                headNode.next = list1;
                headNode = headNode.next;
            } while ((list1 = list1.next) != null);
        }

        return head;
    }



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/d8b6b4358f774294a89de2a6ac4d9337?f=discussion
     *     来源：牛客网
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeNice(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode res = null;
        if(list1.val<list2.val){
            res = list1;
            res.next = mergeNice(list1.next, list2);
        }else{
            res = list2;
            res.next = mergeNice(list1, list2.next);
        }
        return res;
    }



    /**
     *     链接：https://www.nowcoder.com/questionTerminal/d8b6b4358f774294a89de2a6ac4d9337?f=discussion
     *     来源：牛客网
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeNice2(ListNode list1,ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode head=new ListNode(-1);
        head.next=null;
        ListNode root=head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                head.next=list1;
                head=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        return root.next;
    }
}
