package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *                 注意 是   子结构   不是 子树  MMP
 * @Date: Create in 10:10 2019/11/29
 */
public class Topic17HasSubTree {
    /**
     * 判断 root2 是不是root1的子树   先从root1中 找到root2的根节点相同的节点是否存在(可能有多个)  存在的话 遍历 判断子树和root2是否相同
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null){
            return false;
        }
        //如果root1 根节点值 不等于root2根节点值  遍历 左右子树
        if(root1.val != root2.val) {
            return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
        } else {
            //如果根节点相同的话 判断是不是同样的二叉树
            result = isSameTree(root1, root2);
            if (!result) {
                return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    /**
     * 判断root2 是否是root1从根节点开始相同的子结构
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            //一个为空 一个不为空 则代表 两个树 节点数不同 返回false
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root1.val == root2.val) {
            //如果两树根节点值相同 则遍历 左右子树是否相同
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        } else {
            //值不相同的话 返回false
            return false;
        }
    }
}
