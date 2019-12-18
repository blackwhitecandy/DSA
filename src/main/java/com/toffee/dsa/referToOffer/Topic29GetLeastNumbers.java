package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author: glz
 * @Description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 考察排序  可以用快速排序
 * @Date: Create in 9:37 2019/12/18
 */
public class Topic29GetLeastNumbers {
    public static void main (String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> leastNumberList = GetLeastNumbers_Solution(array, 4);
        for (int i : leastNumberList) {
            System.out.println(i);
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> leastNumberList = new ArrayList<>();

        if (input == null) {
            return leastNumberList;
        }
        //快速排序数组
        quicklySort(input, 0, input.length - 1);

        //比较k和数组长度 选取较小值
        int minLength = k > input.length ? input.length : k;
        for (int i = 0; i < minLength; i++) {
            leastNumberList.add(input[i]);
        }

        return leastNumberList;
    }

    /**
     * 快速排序
     * 可以考虑在长度低于某一数值的时候 采用插入排序法  因为元素数量比较少的时候 插入比快速 有更好的效率
     * @param input 数组
     * @param start 开始下标
     * @param end  结束下标
     */
    public static void quicklySort (int[] input, int start, int end) {
        if (start >= end) {
            return ;
        }
        //获取划分点的下标
        int mid = getDiviot(input, start, end);
        //左右部分遍历处理
        quicklySort(input, start, mid - 1);
        quicklySort(input, mid + 1, end);
    }

    /**
     *  快速排序 默认排序第一位元素 选取的元素 可以采用三数取中法  可以更均衡些
     * @param input
     * @param start
     * @param end
     * @return
     */
    private static int getDiviot(int[] input, int start, int end) {
        //划分值flag
        int diviotKey = input[start];

        while (start < end) {
            //倒序遍历找到比划分值小的元素 并交换到start位置
            while (start < end && input[end] > diviotKey) {
                end--;
            }
            input[start] = input[end];

            //正序找到比划分值大的元素 交换至end位置
            while (start < end && input[start] <= diviotKey) {
                start++;
            }
            input[end] = input[start];
        }
        //在最后的start位置上 赋值 划分值
        input[start] = diviotKey;

        return start;
    }
}
