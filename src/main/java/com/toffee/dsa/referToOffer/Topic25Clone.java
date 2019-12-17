package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * ，返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Date: Create in 9:06 2019/12/17
 */
public class Topic25Clone {
    public static void main (String[] args) {
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);
        RandomListNode randomListNode5 = new RandomListNode(5);

        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode3.next = randomListNode4;
        randomListNode4.next = randomListNode5;

        randomListNode1.random = randomListNode3;
        randomListNode2.random = randomListNode5;
        randomListNode4.random = randomListNode2;

        RandomListNode result = Clone(randomListNode1);
        System.out.println(result.toString());
    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //
        // 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
        //        2、遍历链表，A1->random = A->random->next;
        //        3、将链表拆分成原链表和复制后的链表
        RandomListNode currentNode = pHead;
        //遍历当前节点  把每个节点都clone一份放到当前节点后边
        while (currentNode != null) {
            //赋值当前节点
            RandomListNode node = new RandomListNode(currentNode.label);
            //克隆节点指向当前节点下一个节点
            node.next = currentNode.next;
            //当前节点指向克隆节点
            currentNode.next = node;

            //当前节点指向克隆节点的下个节点
            currentNode = node.next;
        }
        //处理随机节点的指向问题
        currentNode = pHead;
        while (currentNode != null) {
            //设置clone节点的随机节点指向  需要对null值判断
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            //当前节点后移
            currentNode = currentNode.next.next;
        }
        currentNode = pHead.next;
        RandomListNode cloneHead = pHead.next;
        //拆分链表
        while (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
            currentNode = currentNode.next;
        }
        return cloneHead;
    }
}
