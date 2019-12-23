package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 判断一棵树 是否平衡二叉树
 * @Date: Create in 2019/12/20
 */
public class Topic39IsBalanced {
    /**
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode booleanTree = new TreeNode(1);
        getBalancedFactor(root, booleanTree);
        if (booleanTree.val < 0) {
            return false;
        }
        return true;
    }

    /**
     * 获取树的深度
     * @param root
     * @param booleanTree 布尔树节点 节点值1代表该节点开始的树平衡，-1代表不平衡
     * @return
     */
    public int getBalancedFactor(TreeNode root, TreeNode booleanTree) {
        if (booleanTree.val < 0) {
            return 0;
        }
        //获取左子树深度
        int leftDepth = (root.left == null ? 0 : getBalancedFactor(root.left, booleanTree));
        //获取右子树深度
        int rightDepth = (root.right == null ? 0 : getBalancedFactor(root.right, booleanTree));
        //判断的当前树是否为平衡树
        int depthDifference = leftDepth - rightDepth;
        //差值大于1或者小于-1  就不是平衡树
        if (depthDifference > 1 || depthDifference < -1) {
            booleanTree.val = -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
