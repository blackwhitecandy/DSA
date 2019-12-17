package com.toffee.dsa.referToOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Queue;

/**
 * @Author: glz
 * @Description: 输入一棵二叉搜索树(BST)，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 思路：树的遍历有三种方式，前序中序和后序，本题可以考虑用链表来实现树的中序
 * @Date: Create in 15:34 2019/12/17
 */
public class Topic26TreeToList {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        treeNode6.left = treeNode4;
        treeNode6.right = treeNode8;

        treeNode4.left = treeNode1;
        treeNode4.right = treeNode5;

        treeNode1.right = treeNode3;
        treeNode3.left = treeNode2;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        treeNode9.right = treeNode10;

        Convert(treeNode6);
        System.out.println(treeNode6);
    }

    /**
     * 采用中序遍历方法
     *
     * @param pRootOfTree
     * @return
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        //如果树节点为null直接返回
        if (pRootOfTree == null) {
            return null;
        }
        //处理左右子树的指向
        dealChildNode(null, pRootOfTree, null);

        //遍历list，设置前后元素的指向
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        //返回中序遍历第一个节点
        return pRootOfTree;
    }

    /**
     * 处理子节点
     *
     * @param left  前序节点
     * @param root  当前节点
     * @param right 后续节点
     * @return
     */
    public static void dealChildNode(TreeNode left, TreeNode root, TreeNode right) {
        //如果左子树不为空 则继续遍历左子树 此时next节点是当前节点
        if (root.left != null) {
            dealChildNode(left, root.left, root);
        } else {
            //前序节点互相指向
            if (left != null) {
                root.left = left;
                left.right = root;
            }
        }
        //如果右子树不为空 则遍历右子树 此时prev节点是当前节点
        if (root.right != null) {
            dealChildNode(root, root.right, right);
        } else {
            //后序节点互相指向
            if (right != null) {
                root.right = right;
                right.left = root;
            }
        }
    }
}


