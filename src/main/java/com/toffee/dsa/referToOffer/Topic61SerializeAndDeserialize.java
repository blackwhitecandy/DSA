package com.toffee.dsa.referToOffer;

import java.util.*;

/**
 * @Author: glz
 * @Description: 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * @Date: Create in 2020/1/6
 */
public class Topic61SerializeAndDeserialize {
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        return root.val + "!" + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserialize1(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] values = str.split("!");
        return makeTree1(values, true);
    }

    /**
     *
     * @param values
     * @param defaultLocation 是否默认取第一个元素 true是  false根据第一个元素的值来取指定下标的元素
     * @return
     */
    private TreeNode makeTree1(String[] values, boolean defaultLocation) {
        String value = values[0];
        if (defaultLocation) {
            //如果是默认取第一个元素则把存储的下标改为1
            values[0] = "1";
        } else  {
            //如果数组下标越界  结束递归
            if (Integer.valueOf(value) >= values.length) {
                return null;
            }
            int intValue = Integer.valueOf(value);
            //根据存储的下标取值
            value = values[intValue];
            values[0] = String.valueOf(intValue + 1);
        }

        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = makeTree1(values, false);
        root.right = makeTree1(values, false);
        return root;
    }

    public TreeNode deserialize(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        PriorityQueue<String> strValueQueue = new PriorityQueue<>();
        Collections.addAll(strValueQueue, str.split("!"));
        return makeTree(strValueQueue);
    }

    private TreeNode makeTree(Queue<String> strValueQueue) {
        String value = strValueQueue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = makeTree(strValueQueue);
        root.right = makeTree(strValueQueue);
        return root;
    }
}
