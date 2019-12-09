package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Date: Create in 9:05 2019/12/6
 */
public class Topic28MoreThanHalfNum {

    public static void main (String[] args) {
        int[] array = {4,2,1,4,2,4};
        System.out.println(MoreThanHalfNumBySort(array));
    }
    /**
     * 思路1：根据题意 达标的希望数应该不是0
     * @param array
     * @return
     */
    public static int MoreThanHalfNumBySort(int [] array) {

        if (array == null || array.length == 0)
            return 0;
        int arrayLength = array.length;
        int targetLength = arrayLength%2 == 0 ? arrayLength/2 + 1 : (arrayLength + 1)/2;//希望数达标长度
        //遍历希望数组 最大下标是希望数长度
        for (int i = 0; i <= targetLength; i++) {
            int current = array[i];
            int targetCount = 0;
            if (current != 0) {
                for (int j = i; j < arrayLength; j++) {
                    if (arrayLength - j + targetCount < targetLength) {
                        break;
                    }
                    if (array[j] == current) {
                        array[j] = 0;
                        targetCount++;
                    }
                }
            }
            if (targetCount >= targetLength) {
                return current;
            }
        }
        return 0;
    }

    /**
     * 思路1：数组两两比较 如果相同话 就保留，不相同就舍弃，长度为奇数的话 最后一个元素保留
     * 最后  保留下来的肯定是有希望出现次数大于长度一半的数， 姑且称之为希望数
     * 再重新遍历数组 对希望数做累加 判断出现次数
     * @param array
     * @return
     */
    public static int moreThanHalfNum(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int arrayLength = array.length;
        int targetLength = (arrayLength + 1)/2;//希望数达标长度
        //希望数 数组
        int[] targetArray = new int[targetLength];
        int targetNum = 0;//希望数  数量
        for (int i = 0; i < arrayLength; i++) {
            //如果是最后一个元素直接保存
            if (i == arrayLength - 1) {
                targetArray[targetNum++] = array[i];
            } else {
                //如果不是最后一个元素 判断相邻元素是否相等，相等保存
                if (array[i] == array[i + 1] && !arrayContains(targetArray, array[i])) {
                    targetArray[targetNum++] = array[i];
                }
            }
        }
        //遍历希望数
        for (int i = 0; i < targetNum; i++) {
            int target = targetArray[i];//希望数
            int targetCount = 0;//希望数出现次数
            for (int j = 0; j < arrayLength; j++) {
                if (array[j] == target) {
                    targetCount++;
                }
                //如果希望数长度达标直接返回
                if (targetCount >= targetLength) {
                    return target;
                }
                //如果希望数出现次数+数组剩余元素个数 < 达标希望数长度 直接结束循环
                if (targetCount + arrayLength - j < targetLength) {
                    break;
                }
            }
        }
        return 0;
    }

    /**
     * 判断数组中是否包含对应元素
     * @param targetArray
     * @param target
     * @return
     */
    private static boolean arrayContains(int[] targetArray, int target) {
        if (targetArray == null || targetArray.length == 0) {
            return false;
        }
        for (int i : targetArray) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }
}
