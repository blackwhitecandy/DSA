package com.toffee.dsa.referToOffer;

import java.util.Arrays;

/**
 * @Author glz
 * @Description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同
 * 二叉搜索树左子树都比根节点小，右子树都比根节点大
 * 思路：如果是后序遍历的话 则最后一个元素就是根节点，通过比较大小把数组分成两部分 再依次判断这两部分是不是二叉搜索树
 * @Date 2019-12-02 下午9:15
 */
public class Topic23VerifySquenceOfBST {
    public static void main ( String[] args) {
        int[] sequence = {6,5,4,7};
//        System.out.println(verifySquenceOfBST(sequence));
        System.out.println("33".compareTo("22"));
    }
    public static boolean verifySquenceOfBST (int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        //判断是否为空树  空树也是二叉搜索树 空树  只有一个节点的树都是搜索二叉树
        if (sequence.length == 1) {
            return true;
        }
        int length = sequence.length;
        int rootValue = sequence[length - 1];//获取跟节点的值
        int leftIndex = 0;
        int rightIndex = length - 2;
        //获取左子树最大下标
        while (sequence[leftIndex] < rootValue && leftIndex < length - 1) {
            leftIndex++;
        }
        for (int i = leftIndex; i < length; i++) {
            if (sequence[i] < rootValue) {
                return false;
            }
        }
        int[] leftArray = new int[leftIndex];
        int[] rightArray = new int[length - leftIndex - 1];
        System.arraycopy(sequence, 0, leftArray, 0, leftIndex);
        System.arraycopy(sequence, leftIndex, rightArray, 0, length - leftIndex - 1);
        return verifySquenceOfBST(leftArray)
                && verifySquenceOfBST(rightArray);

    }
}
