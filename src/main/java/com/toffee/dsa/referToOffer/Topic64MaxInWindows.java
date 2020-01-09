package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author: glz
 * @Description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @Date: Create in 2020/1/8
 */
public class Topic64MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (num == null || num.length == 0) {
            return null;
        }
        int length = num.length;
        if (size < 1 || size > length) {
            return resultList;
        }
        int left = 0;
        int right = size > length ? length - 1 : size - 1;
        int maxIndex = 0;
        //获取第一个滑动窗口的最大值
        maxIndex = findMaxOfWindows(maxIndex, num, right, resultList);

        while (right < length - 1) {
            right++;
            //如果最大数小于右侧增加的数 则新增的数是最大值   更改最大数下标
            if (num[maxIndex] <= num[right]) {
                maxIndex = right;
                resultList.add(num[maxIndex]);
            } else if (left != maxIndex){
                //如果最左侧的数不是滑动窗口的最大数 则最大数不变 则left++  maxIndex 不变
                resultList.add(num[maxIndex]);
            } else {
                maxIndex = left + 1;
                //不能判断单个滑动窗口的最大值 需要循环判断
                maxIndex = findMaxOfWindows(maxIndex, num, right, resultList);
            }
            left++;
        }
        return resultList;
    }

    /**
     * 获取单个滑动窗口中的最大值
     * @param maxIndex
     * @param num
     * @param right
     * @param resultList
     */
    public int findMaxOfWindows(int maxIndex, int[] num, int right, ArrayList<Integer> resultList) {
        for (int i = maxIndex + 1; i <= right; i++){
            if (num[i] >= num[maxIndex]) {
                maxIndex = i;
            }
        }
        resultList.add(num[maxIndex]);
        return maxIndex;
    }
}
