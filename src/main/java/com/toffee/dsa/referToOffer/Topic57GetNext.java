package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @Date: Create in 2020/1/6
 */
public class Topic57GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        //判断节点的右孩子和父节点是否存在
        if (pNode.right != null) {
            //如果有右孩子节点 则中序遍历右孩子节点的第一个节点并返回
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode.next != null) {
            return getParentNext(pNode, pNode.next);
        }
        return null;
    }

    /**
     * 找父节点的下个节点
     * @param currentNode 当前节点
     * @param parentNode 父节点
     * @return
     */
    public TreeLinkNode getParentNext(TreeLinkNode currentNode, TreeLinkNode parentNode) {
        //如果当前节点是父节点的左孩子 返回父节点
        if (currentNode == parentNode.left) {
            return parentNode;
        } else if (parentNode.next != null) {
            //如果当前节点是右节点而且父节点还有父节点 就继续遍历
            return getParentNext(parentNode, parentNode.next);
        }
        return null;
    }
}
