package com.toffee.dsa.referToOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: glz
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路:感觉类似于文件夹的广度有先遍历 但是又有所不同，文件夹广度优先遍历能一下获取到子文件和子目录集合，但是树获取不到
 * @Date: Create in 2019/12/2
 */
public class Topic22PrintFromTopToBottom {
    public static void main (String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(9);
        TreeNode treeNode9 = new TreeNode(10);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode4.left = treeNode9;
        treeNode6.left = treeNode8;
        treeNode8.left = treeNode7;

        ArrayList<Integer> treeList = printFromTopToBottom(treeNode);
        for (int i : treeList) {
            System.out.print(i + "-->");
        }
    }
    public  static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> treeNodeValueList = new ArrayList<>();//存储树节点值
        /**
         * 使用ArrayList遍历的时候 会报错
         * Exception in thread "main" java.util.ConcurrentModificationException
         * 因为 arraylist有个modcount 字段 每次更新操作都会+1
         * 遍历的时候会判断modcount是不是保持不变，如果有变化就会报错上面信息
         * 所以遍历的时候需要注意
         */
        ArrayList<TreeNode> treeNodeList = new ArrayList<>();//存储树各个节点
        if (root == null) {
            return treeNodeValueList;
        } else {
            treeNodeList.add(root);//添加根节点
            //遍历树节点list所有节点 如果是分支节点 则在结果集中添加当前节点值，并把左右子节点添加到节点队列中，并删除头结点，
            // 如果是叶子节点则继续遍历 直到结束
            while (treeNodeList != null && treeNodeList.size() != 0) {
                TreeNode treeNode = treeNodeList.get(0);//获取头结点
                //如果不是叶子节点
                if (treeNode != null) {
                    //添加左右子节点到树节点list中
                    treeNodeList.add(treeNode.left);
                    treeNodeList.add(treeNode.right);

                    //添加当前节点值到结果list中
                    treeNodeValueList.add(treeNode.val);
                }
                treeNodeList.remove(0);//移除头结点
            }
        }
        return treeNodeValueList;
    }
}
