package com.toffee.dsa.referToOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * @Author: glz
 * @Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @Date: Create in 2020/1/6
 */
public class Topic58IsSymmetrical {
    /**
     * 如果二叉树是对称的 则左子树是右子树的镜像
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        }
        //获取左右子树
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        //判断左右子树是否对称
        if (left != null && right != null) {
            return (left.val == right.val) && mirror(left, right);
        }
        return false;
    }

    /**
     *
     * @param left
     * @param right
     * @return
     */
    public boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            //如果两个都是null 返回true
            return true;
        } else if (left != null && right != null) {
            //其余情况还要 交叉判断
            return (left.val == right.val)
                    && mirror(left.left, right.right)
                    && mirror(left.right, right.left);
        }
        //其余情况都是false
        return false;
    }
}
