package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @Date: Create in 2019/12/23
 */
public class Topic40FindNumsAppearOnce {
    /**
     * 找到两个只出现一次的数字
     * //num1,num2分别为长度为1的数组。传出参数
     * //将num1[0],num2[0]设置为返回结果
     * 两个相同的数字 可以通过位运算的异或操作 变成0  但是有两个只出现一次的数字
     * 能找到第一个 第二个就好找了
     *
     * 思路 快速排序 然后 前后判断是否相同。。
     * @param array
     * @param num1
     * @param num2
     */
    public void findNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        if (array == null) {
            return ;
        }

        //对数组进行快速排序
        quicklySort(array, 0, array.length - 1);

        //找到第一个只出现一次的数
        int i = 0;
        for (; i < array.length - 1; i+=2) {
            if ((array[i]^array[i+1]) != 0) {
                num1[0] = array[i];
                break;
            }
        }

        //从第一个出现一次的数的下标开始 按照位运算的异或操作 算出第二个数
        num2[0] = 0;
        for (int j = i + 1; j < array.length; j++) {
            num2[0] ^= array[j];
        }
    }

    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     */
    public void quicklySort(int[] array, int start, int end) {
        if (start >= end) {
            return;

        }
        //获取划分值的索引下标
        int diviotIndex = getDiviotIndex(array, start, end);
        //递归处理 左右两部分
        quicklySort(array, start, diviotIndex - 1);
        quicklySort(array, diviotIndex + 1, end);
    }

    /**
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int getDiviotIndex(int[] array, int start, int end) {
        int diviotKey = array[start];
        //前后同时遍历 直到start >= end
        while (start < end) {
            //倒序遍历找到第一个比划分值小的元素
            while (start < end && array[end] > diviotKey) {
                end--;
            }
            //小元素交换到前边
            array[start] = array[end];

            //遍历找到第一个比划分值大的元素 并交还到后边去
            while(start < end && array[start] <= diviotKey) {
                start++;
            }
            array[end] = array[start];
        }
        //最后start停留的位置 赋值给start
        array[start] = diviotKey;
        return start;
    }
}
