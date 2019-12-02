package com.toffee.dsa.referToOffer;

import org.hibernate.validator.constraints.EAN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: glz
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 思路：获取弹出序列每个元素在压入序列中的下标  如果有元素找不到 则肯定不是弹出序列；如果所有元素都找到就要判断
 * 假设元素A下标为10 后边不能够有两个（及以上）相邻元素的下标（小于10）升序出现：
 * 比如:10...1、3...
 * 10...2、3...
 * 10...2、5...
 * 10...2、7...
 * 这种都不可能是弹出序列
 * @Date: Create in  2019/12/2
 */
public class Topic21IsPopOrder {
    public static void main (String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4,3,5,2,1};
        if (isPopOrderByStack(pushA, popA)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    /**
     * 此算法 默认pushA和popA长度相等
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean isPopOrder(int[] pushA, int[] popA) {
        //判断压入序列是否为空
        if (pushA == null || pushA.length == 0) {
            return false;
        }
        int length = pushA.length;//序列长度
        int[] popIndexArray = new int[length];
        //循环获取popA中元素在pushA中的顺序
        for (int i = 0; i < length; i++) {
            //获取索引下标
            int index = getIndexFromPushA(pushA, popA[i]);
            //如果下标小于0  直接返回false
            if (index < 0) {
                return false;
            }
            popIndexArray[i] = index;
        }
        //分析这个顺序索引数组 判断popA是不是弹出序列
        for (int i = 1; i < popIndexArray.length - 1; i++) {
            //如果当前索引值 小于 下一个元素的索引值 就判断在i之前是否有更大的索引值 有的话 直接返回false
            if (popIndexArray[i] < popIndexArray[i + 1]) {
                //判断i+1的元素值是不是小于i 之前的某一元素值   如果小于 就代表这不是一个弹出序列
                if (isLessThanPre(popIndexArray, i - 1, popIndexArray[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 此算法 默认pushA和popA长度相等
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean isPopOrderByStack(int[] pushA, int[] popA) {
        //判断压入序列是否为空
        if (pushA == null || pushA.length == 0) {
            return false;
        }
        int length = pushA.length;//序列长度
        int[] integerArrayStack = new int[length];//用数组模拟栈
        int stackLength = 0;//数组栈长度
        int popAIndex = 0;
        //循环压入 压入序列
        for (int i = 0; i < length; i++) {
            integerArrayStack[stackLength++]= pushA[i];//给数组栈添加元素
            //遍历弹出序列和数组栈值  模拟弹出 同时更新数组栈长度
            while (stackLength > 0 && integerArrayStack[stackLength - 1] == popA[popAIndex]) {
                integerArrayStack[stackLength - 1] = 0;//赋初始值
                stackLength--;//数组栈长度减一
                popAIndex++;//弹出序列 下标++
            }
        }
        //如果数组栈索引下标最-1  即经历了一个压入序列和一个弹出序列 刚好为空  就代表该弹出序列是一个对应的弹出序列
        if (stackLength <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断target是否小于 flagindex之前的元素
     * @param popIndexArray
     * @param flagIndex
     * @param target
     * @return
     */
    private static boolean isLessThanPre(int[] popIndexArray, int flagIndex, int target) {
        for (int i = 0; i <= flagIndex; i++) {
            if (target < popIndexArray[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取元素在数组中的下标
     *
     * @param pushA
     * @param target
     * @return target's index of pushA
     */
    private static int getIndexFromPushA(int[] pushA, int target) {
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
