package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author: glz
 * @Description: 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 思路：也就是遍历查找树的路径，找到路径上节点值的和是输入整数的路径
 * @Date: Create in 14:30 2019/12/3
 */
public class Topic24FindPath {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(15);
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
//        treeNode3.left = new TreeNode(11);

        ArrayList<ArrayList<Integer>> resultList = findPath(treeNode, 18);
        System.out.println(resultList.size());
    }

    /**
     * 这个方法和广度优先遍历有相似之处 最终返回结果还需要逆转顺序
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        //树节点list 依次存储树节点并把当前节点的值设置为当天路径和的值
        ArrayList<TreeNode> treeNodeArrayList = new ArrayList<>();
        treeNodeArrayList.add(root);//树节点先添加根节点

        ArrayList<ArrayList<Integer>> pathArrayList = new ArrayList<>();//存放所有节点路径list值
        pathArrayList.add(new ArrayList<>(root.val)); //所有节点list中添加一个包含根节点值的list

        //遍历树节点list 每次遍历结束后都删除掉list中的头结点  还有所有节点路径list中的头结点
        while (treeNodeArrayList != null && treeNodeArrayList.size() != 0) {
            //获取当前节点
            TreeNode treeNode = treeNodeArrayList.get(0);
            int treeNodeValue = treeNode.val;
            //如果当前节点的左右子树都是null 如果当前叶子节点的值等于target 代表当前路径是一个目标路径
            // 保存当前路径遍历到最终结果list中
            if (treeNode.left == null & treeNode.right == null && treeNodeValue == target) {
                resultList.add(pathArrayList.get(0));//保存当前路径遍历到最终结果list中
            } else {
                //如果左节点不为空，给左节点加上根节点的值
                if (treeNode.left != null) {
                    addTreeNode(treeNode.left, pathArrayList, treeNodeArrayList, treeNodeValue);
                }
                //如果右节点不为空，给右节点加上根节点的值
                if (treeNode.right != null) {
                    addTreeNode(treeNode.right, pathArrayList, treeNodeArrayList, treeNodeValue);
                }
            }
            //删除头节点
            treeNodeArrayList.remove(0);
            pathArrayList.remove(0);
        }
        return resultList;
    }

    /**
     * 添加当前树节点到树节点list中， 并且拷贝一份节点路径list放到所有路径list中
     *
     * @param treeNode          当前节点
     * @param pathArrayList     所有路径list
     * @param treeNodeArrayList 树节点list
     * @param treeNodeValue     当前根节点值
     */
    public static void addTreeNode(TreeNode treeNode, ArrayList<ArrayList<Integer>> pathArrayList, ArrayList<TreeNode> treeNodeArrayList, int treeNodeValue) {
        //深度拷贝一份当前根节点路径list
        ArrayList<Integer> treeNodeValueArrayList = deepCopyArrayList(pathArrayList.get(0));
        //给新路径list加上左节点
        treeNodeValueArrayList.add(treeNode.val);
        //把新list添加到所有路径list当中
        pathArrayList.add(treeNodeValueArrayList);

        //给当前点值加上当前根节点的值
        treeNode.val += treeNodeValue;
        //添加当前节点进树节点list
        treeNodeArrayList.add(treeNode);
    }

    /**
     * 深度拷贝list
     */
    public static ArrayList<Integer> deepCopyArrayList(ArrayList<Integer> srcList) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (srcList == null || srcList.size() == 0) {
            return resultList;
        }
        for (int i : srcList) {
            resultList.add(i);
        }
        return resultList;
    }
}
