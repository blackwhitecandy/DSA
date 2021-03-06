package com.toffee.dsa.referToOffer;

import java.util.Stack;

/**
 * @Author glz
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 思路：1使用两个stack来分别存储  2使用list来处理
 * @ Date 2019-11-26
 */
public class Topic13ReOrderArray {
    public static void main(String[] args) {
        int[] array = {1, 2,3, 4, 5, 6, 7, 8, 9, 10};
        //int[] array = {1};
        reOrderArrayInsert(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * @param array
     */
    public static void reOrderArray(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int length = array.length;
        int[] oddArray = new int[length];
        int[] evenArray = new int[length];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i : array) {
            if (i % 2 == 1) {
                oddArray[oddIndex++] = i;
            } else {
                evenArray[evenIndex++] = i;
            }
        }
        System.arraycopy(oddArray, 0, array, 0, oddIndex);
        System.arraycopy(evenArray, 0, array, oddIndex, evenIndex);

    }

    /**
     * 思路 采用插入排序的思想 所有偶数后移，奇数插入到奇数和偶数中间的位置
     * @param array
     */
    public static void reOrderArrayInsert(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int length = array.length;
        int valueBak = 0;
        int oddNum = array[0]&1;//奇数数量
        for (int i = 1; i < length; i++) {
            //奇数情况 插入到奇数和偶数中间
            if ((array[i] & 1) == 1) {
                valueBak = array[i];//备份当前奇数

                //所有偶数后移
                for (int j = i; j > oddNum; j-- ) {
                    array[j] = array[j - 1];
                }
                array[oddNum] = valueBak;//设置当前奇数
                ++oddNum;//奇数数目加1
            }
        }

    }

    /**
     * 用栈来实现
     *
     * @param array
     */
    public static void reOrderArrayByStack(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        Stack<Integer> oddStack = new Stack<>();//奇数是odd
        Stack<Integer> evenStack = new Stack<>();//偶数是even
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 1) {
                //奇数栈粗存放奇数
                oddStack.push(array[i]);
            } else {
                //偶数栈存放偶数
                evenStack.push(array[i]);
            }
        }

        while (!evenStack.isEmpty()) {
            array[length - 1] = evenStack.pop();
            length--;
        }
        while (!oddStack.isEmpty()) {
            array[length - 1] = oddStack.pop();
            length--;
        }
    }
}
