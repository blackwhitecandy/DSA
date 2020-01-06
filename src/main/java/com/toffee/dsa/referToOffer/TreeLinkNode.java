package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @Date: Create in 2020/1/6
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;

    //父节点
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
