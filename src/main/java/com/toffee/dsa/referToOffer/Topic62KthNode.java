package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @Date: Create in 2020/1/7
 */
public class Topic62KthNode {
    public TreeNode kthNode1(TreeNode pRoot, int k) {
        if (k < 1) {
            return null;
        }
        //构造一个数组用来存放最小的k个数 下标0的位置存放元素的个数
        TreeNode kNode = new TreeNode(k);

        getKthNodeByK(kNode, pRoot);
        if (kNode.val == -1) {
            return  kNode;
        }
        return null;
    }

    private boolean getKthNodeByK(TreeNode kNode, TreeNode pRoot) {
        if (kNode.val < 0) {
            return false;
        }
        if (pRoot != null) {
            if (getKthNodeByK(kNode, pRoot.left)) {
                return true;
            }

            kNode.val = kNode.val - 1;
            if (kNode.val == 0) {
                kNode = pRoot;
                return true;
            }

            if (getKthNodeByK(kNode, pRoot.right)){
                return true;
            }
        }
        return false;
    }

    public TreeNode kthNode(TreeNode pRoot, int k) {
        if (k < 1) {
            return null;
        }
        //构造一个数组用来存放最小的k个数 下标0的位置存放元素的个数
        TreeNode[] kArray = new TreeNode[k + 1];
        kArray[0] = new TreeNode(0);

        getKthNode(kArray, pRoot, k);
        if (kArray[0].val == k) {
            return  kArray[k];
        }
        return null;
    }

    /**
     *
     * @param kArray
     * @param pRoot
     * @param k
     */
    private void getKthNode(TreeNode[] kArray, TreeNode pRoot, int k) {
        //处理开始前判断一下元素个数是否到k
        if (kArray[0].val >= k) {
            return ;
        }
        if (pRoot != null) {
            getKthNode(kArray, pRoot.left, k);

            //处理完左节点判断一下元素个数是否到k
            if (kArray[0].val >= k) {
                return ;
            }

            kArray[kArray[0].val + 1] = pRoot;
            kArray[0].val = kArray[0].val +  1;

            getKthNode(kArray, pRoot.right, k);
        }
        return ;
    }
}
