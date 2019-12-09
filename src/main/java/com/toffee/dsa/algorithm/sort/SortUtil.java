package com.toffee.dsa.algorithm.sort;

/**
 * @Author: glz
 * @Description:
 * @Date: Create in 15:55 2019/12/9
 */
public class SortUtil {
    /**
     * 交换数组中低位和高位的值
     * @param array
     * @param low
     * @param high
     */
    public static void swapArray(int[] array, int low, int high) {
        int temValue = array[high];
        array[high] = array[low];
        array[low] = temValue;
    }
}
