package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
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
 *
 *     	思路  递归交换节点
 * @Date: Create in 11:07 2019/11/29
 */
public class Topic18Mirror {
    public void mirror(TreeNode root) {
        if (root != null) {
            //遍历处理左右子树
            mirror(root.left);
            mirror(root.right);
            //交换左右子节点
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
        }
    }
}
