package com.toffee.dsa.algorithm.sort;

/**
 * @Author: glz
 * @Description: 插入排序 可以想象一下扑克牌摸牌的时候 在手里面的排序
 * @Date: Create in 11:14 2019/12/9
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] array = {4, 1, 9, 22, 5};
        insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void insertSort(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int length = array.length;//获取数组长度
        //for循环遍历，从数组第二位开始
        for (int i = 1; i < length; i++) {
            //如果前一个元素大于当前元素 就从当前倒序依次比较，比当前值temp大的都后移一位
            if (array[i - 1] > array[i]) {
                int temp = array[i];
                int jIndex = i - 1;
                //比temp大的值都后移一位
                while (jIndex >= 0 && array[jIndex] > temp) {
                    array[jIndex + 1] = array[jIndex];
                    jIndex--;
                }

                //后移结束后 在jIndex下标处赋值为当前值
                array[jIndex + 1] = temp;
            }

        }
    }
}
