package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Date: Create in 11:57 2019/11/22
 */
public class Topic4ReConstructBinaryTree {

    public static void main (String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode.val);
    }
    /**
     * 根据前序 和 中序  重新构造二叉树
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = getRootNodeFromArray(pre, in);
        return treeNode;
    }

    /**
     * 获取根节点
     */
    public static TreeNode getRootNodeFromArray(int [] pre,int [] in) {
        if (null == pre || pre.length == 0) {
            return null;
        }
        if (pre.length == 1){
            return new TreeNode(pre[0]);
        }
        //取到根节点
        TreeNode treeNode = new TreeNode(pre[0]);

        int rootIndex = getRootIndex(pre, in);

        //遍历获取左子树根节点
        int[] leftPre = new int[rootIndex];
        System.arraycopy(pre, 1, leftPre, 0, rootIndex);
        int[] leftIn = new int[rootIndex];
        System.arraycopy(in, 0, leftIn, 0, rootIndex);
        treeNode.left = getRootNodeFromArray(leftPre, leftIn);

        //遍历获取右子树根节点
        int[] rightPre = new int[pre.length - rootIndex - 1];
        System.arraycopy(pre, rootIndex + 1, rightPre, 0, pre.length - rootIndex - 1);
        int[] rightIn = new int[in.length - rootIndex - 1];
        System.arraycopy(in, rootIndex + 1, rightIn, 0, in.length - rootIndex - 1);
        treeNode.right = getRootNodeFromArray(rightPre, rightIn);

        return treeNode;
    }

    /**
     * 获取数组root的下标 获取不到 返回 -1
     * @return
     */
    public static int getRootIndex(int [] pre,int [] in) {
        int result = -1;
        //判断两个数组 是否还有值
        if (pre != null && in != null && pre.length > 0 && in.length > 0) {
            int rootValue = pre[0];
            //获取root下标并返回
            for (int i = 0; i < in.length; i++) {
                if (in[i] == rootValue) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}

/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}