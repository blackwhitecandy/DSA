package com.toffee.dsa.referToOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: glz
 * @Description: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * @Date: Create in 2019/12/20
 */
public class Topic38TreeDepth {
    /**
     * 队列来实现树的广度优先遍历，最后遍历到叶子节点 就是最大长度
     * @param root
     * @return
     */
    public int treeDepthByQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //树的深度
        int depth = 0;

        //定义一个存储list树节点的队列
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>();
        //添加第一个元素
        root.val = 1;
        priorityQueue.add(root);

        //遍历队列 遍历到最后一个就是深度最大的节点 获取节点存取的值
        TreeNode currentNode = null;
        while (priorityQueue != null && (currentNode = priorityQueue.poll()) != null) {
            //遍历左子树 节点存储左子树节点深度
            if (currentNode.left != null) {
                currentNode.left.val = currentNode.val + 1;
                priorityQueue.add(currentNode.left);
            }
            //遍历右子树 节点存储右子树节点深度
            if (currentNode.right != null) {
                currentNode.right.val = currentNode.val + 1;
                priorityQueue.add(currentNode.right);
            }
            depth = currentNode.val;
        }
        //返回树的深度
        return depth;
    }

    /**
     * 通过list来模仿队列实现
     * @param root
     * @return
     */
    public int treeDepthByArrayList(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //树的深度
        int depth = 0;

        //定义一个存储list树节点的队列
        ArrayList<TreeNode> treeNodeArrayList = new ArrayList<>();
        //添加第一个元素
        root.val = 1;
        treeNodeArrayList.add(root);

        //遍历队列 遍历到最后一个就是深度最大的节点 获取节点存取的值
        TreeNode currentNode = null;
        while (treeNodeArrayList != null && (currentNode = treeNodeArrayList.remove(0)) != null) {
            //遍历左子树 节点存储左子树节点深度
            if (currentNode.left != null) {
                currentNode.left.val = currentNode.val + 1;
                treeNodeArrayList.add(currentNode.left);
            }
            //遍历右子树 节点存储右子树节点深度
            if (currentNode.right != null) {
                currentNode.right.val = currentNode.val + 1;
                treeNodeArrayList.add(currentNode.right);
            }
            depth = currentNode.val;
        }
        //返回树的深度
        return depth;
    }

    /**
     * 通过递归来实现
     * @param root
     * @return
     */
    public int treeDepthByRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepthByRecursive(root.left), treeDepthByRecursive(root.right)) + 1;
    }

}
