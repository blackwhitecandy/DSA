package com.toffee.dsa.algorithm.sort;

/**
 * @Author: glz
 * @Description: 选择排序时间复杂度O(n^2) 之前的冒泡排序进行了太多的交换处理，选择排序相对交换次数会少一些
 * @Date: Create in 2019/12/9
 */
public class SelectSort {
    public static void main (String[] args) {
        int[] array = {1, 4, 9, 22, 5, 8};
        selectSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
    /**
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        //判断数组是否为空
        if (array == null || array.length == 0) {
            return ;
        }

        int minIndex = 0;//默认最小下标
        int length = array.length;
        //for循环 每次获取到最小的值
        for (int i = 0; i < length; i++) {
            minIndex = i;//设置最小下标为i
            //for循环处理  如果有值比数组中下标为minIndex的值小的话 就更新minIndex
            for (int j = i; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            //循环结束后 minIndex存放的就是数组中最小值的下标 然后再和i交换
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
