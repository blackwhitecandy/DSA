package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author: glz
 * @Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @Date: Create in 2020/1/6
 */
public class Topic60Print {
    /**
     * 把每一层的节点都添加到list中  list中循环开始的时候 始终保持上一层的所有节点 然后根据方向进行处理
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        //结果list
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        //从左到右树节点list
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        //如果头结点为空 则返回null
        if (pRoot == null) {
            return resultList;
        }
        //把根节点添加到当前节点list中
        nodeList.add(pRoot);

        //把根节点的值放入list中存放到结果list里面
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(pRoot.val);
        resultList.add(rootList);

        //遍历所有的树节点 根据flag 添加到值list中  并保存到结果list  节点遍历完 结束循环
        while (true) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            int nodeLength = nodeList.size();
            if (nodeLength == 0) {
                break;
            }
            //获取上一层节点list
            for (int i = 0; i < nodeLength; i++) {
                TreeNode currentNode = nodeList.remove(0);
                if (currentNode.left != null) {
                    integerArrayList.add(currentNode.left.val);
                    nodeList.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    integerArrayList.add(currentNode.right.val);
                    nodeList.add(currentNode.right);
                }
            }
            //如果值list 不为空 则添加到结果list中
            if (integerArrayList != null && integerArrayList.size() > 0) {
                resultList.add(integerArrayList);
            }
        }

        return resultList;
    }

}
