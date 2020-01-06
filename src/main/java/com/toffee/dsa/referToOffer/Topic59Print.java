package com.toffee.dsa.referToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: glz
 * @Description: 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 * @Date: Create in 2020/1/6
 */
public class Topic59Print {
    /**
     * 把每一层的节点都添加到list中  list中循环开始的时候 始终保持上一层的所有节点 然后根据方向进行处理
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        //结果list
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        //从左到右树节点list
        ArrayList<TreeNode> leftRightList = new ArrayList<>();
        //从右到左树节点list
        ArrayList<TreeNode> rightLeftList = new ArrayList<>();
        //如果头结点为空 则返回null
        if (pRoot == null) {
            return resultList;
        }
        //把根节点添加到当前节点list中
        leftRightList.add(pRoot);

        //把根节点的值放入list中存放到结果list里面
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(pRoot.val);
        resultList.add(rootList);

        //左右顺序flag  true从右到左 false从左到右
        boolean printSortFlag = true;

        //遍历所有的树节点 根据flag 添加到值list中  并保存到结果list  节点遍历完 结束循环
        while (true) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            ArrayList<TreeNode> currentNodeList = printSortFlag ? leftRightList : rightLeftList;
            int nodeLength = currentNodeList.size();
            if (nodeLength == 0) {
                break;
            }
            //获取上一层节点list
            for (int i = nodeLength - 1; i >= 0; i--) {
                TreeNode currentNode = currentNodeList.remove(i);
                if (printSortFlag) {
                    addTreeNodeAndVal(currentNode.right, currentNode.left, integerArrayList, rightLeftList);
                } else {
                    addTreeNodeAndVal(currentNode.left, currentNode.right, integerArrayList, leftRightList);
                }
            }
            //如果值list 不为空 则添加到结果list中
            if (integerArrayList != null && integerArrayList.size() > 0) {
                resultList.add(integerArrayList);
            }
            //每次循环后都改变方向
            printSortFlag = printSortFlag ? false : true;
        }

        return resultList;
    }

    /**
     * 往list中添加节点 和 值
     * @param prev
     * @param next
     */
    public void addTreeNodeAndVal(TreeNode prev, TreeNode next, ArrayList<Integer> integerArrayList, ArrayList<TreeNode> nodeList) {
        if (prev != null) {
            integerArrayList.add(prev.val);
            nodeList.add(prev);
        }
        if (next != null) {
            integerArrayList.add(next.val);
            nodeList.add(next);
        }
    }

    /**
     * 把每一层的节点都添加到list中  list中循环开始的时候 始终保持上一层的所有节点 然后根据方向进行处理
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> printTreeNodeByStack(TreeNode pRoot) {
        //结果list
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        //节点栈
        Stack<TreeNode> treeNodeLeftStack = new Stack<>();
        Stack<TreeNode> treeNodeRightStack = new Stack<>();
        Stack<TreeNode> currentStack;
        // 如果头结点为空 则返回null
        if (pRoot == null) {
            return resultList;
        }
        // 把根节点添加到当前节点stack中
        treeNodeLeftStack.add(pRoot);

        //把根节点的值放入list中存放到结果list里面
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(pRoot.val);
        resultList.add(rootList);

        //左右顺序flag  true从右到左 false从左到右
        boolean printSortFlag = true;

        //遍历所有的树节点 根据flag 添加到值list中  并保存到结果list  节点遍历完 结束循环
        while (treeNodeLeftStack != null || treeNodeRightStack != null) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            currentStack = printSortFlag ? treeNodeLeftStack : treeNodeRightStack;
            //获取上一层节点list
            while (currentStack.peek() != null) {
                TreeNode currentNode = currentStack.pop();
                if (printSortFlag) {
                    //偶数层 从右到左处理
                    addTreeNodeAndVal(currentNode.right, currentNode.left, integerArrayList, treeNodeRightStack);
                } else {
                    //奇数层 从左到右处理
                    addTreeNodeAndVal(currentNode.left, currentNode.right, integerArrayList, treeNodeLeftStack);
                }
            }
            //如果值list 不为空 则添加到结果list中
            if (integerArrayList != null && integerArrayList.size() > 0) {
                resultList.add(integerArrayList);
            }
            //每次循环后都改变方向
            printSortFlag = printSortFlag ? false : true;
        }

        return resultList;
    }

    /**
     * 往list中添加节点 和 值
     * @param prev
     * @param next
     */
    public void addTreeNodeAndVal(TreeNode prev, TreeNode next, ArrayList<Integer> integerArrayList, Stack<TreeNode> nodeStack) {
        if (prev != null) {
            integerArrayList.add(prev.val);
            nodeStack.add(prev);
        }
        if (next != null) {
            integerArrayList.add(next.val);
            nodeStack.add(next);
        }
    }
}
