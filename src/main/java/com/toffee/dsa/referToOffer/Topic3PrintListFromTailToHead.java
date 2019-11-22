package com.toffee.dsa.referToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: glz
 * @Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 * @Date: Create in 9:01 2019/11/21
 */
public class Topic3PrintListFromTailToHead {
    public static void main (String[] args){
        ListNode listNode1 = new ListNode(67);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(24);
        ListNode listNode4 = new ListNode(58);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ArrayList<Integer> integerArrayList = printListFromTailToHead(listNode1);

        for (Integer integer : integerArrayList) {
            System.out.println(integer);
        }
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        //listnode不为null的情况 进行遍历 获取值 放到arrayList中
        if (listNode != null) {
            do {
                integerArrayList.add(Integer.valueOf(listNode.val));
                listNode = listNode.next;
            } while (listNode != null);

            int divLength = (integerArrayList.size())/2;
            int length = integerArrayList.size() - 1;
            for (int i = 0; i < divLength; i++) {
                Integer integer = integerArrayList.get(i);
                integerArrayList.set(i, integerArrayList.get(length - i));
                integerArrayList.set(length - i, integer);
            }
        }
        return integerArrayList;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

