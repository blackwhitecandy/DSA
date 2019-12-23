package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 统计一个数字在排序数组中出现的次数。
 * @Date: Create in 2019/12/20
 */
public class Topic37GetNumberOfK {
    /**
     * 思路  二分查找定位一个下标，然后前后遍历 统计数目
     * @param array
     * @param k
     * @return
     */
    public int getNumberOfK(int[] array , int k) {
        int length;
        if (array == null || (length = array.length) == 0) {
            return 0;
        }
        //找到k所在的某一个下标
        int index = binarySearch(array, k, 0, length);
        //判断是否找到
        if (index >= 0) {
            int sum = 1;
            int leftIndex = index;
            while (leftIndex > 0 && array[--leftIndex] == k) {
                sum++;
            }
            while (index < length - 1 && array[++index] == k) {
                sum++;
            }
            return sum;
        }
        return 0;
    }

    /**
     * 二分查找
     * @param array
     * @param k
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    public int binarySearch(int[] array, int k, int start, int end) {
        int mid;
        while (start < end) {
            mid = (start + end)/2;
            if (k == array[mid]) {
                return mid;
            } else if (k > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
