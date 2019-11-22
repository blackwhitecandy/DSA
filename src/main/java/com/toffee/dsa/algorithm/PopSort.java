package com.toffee.dsa.algorithm;

/**
 * @Author: glz
 * @Description: 冒泡排序
 * @Date: Create in 15:00 2019/11/1
 */
public class PopSort {
    public static void main(String[] args) {
        int[] arrays = new int[100];
        for (int i = 0; i < 100; i++) {
            arrays[i] = (int) (Math.random() * 1000 %1000 + 1);
        }
        //int[] arrays = {43,3,4,9,45};
        SwapPopSortMethod(arrays);
        for (int i : arrays) {
            System.out.print(i + " < ");
        }
    }

    private static void PopSortMethod(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return ;
        }
        //获取数组长度
        int length = arrays.length;
        //双重循环冒泡处理
        for (int i = 0; i < length; i++) {
            int tempValue = arrays[i];
            for (int j = i + 1; j < length; j++) {
                //如果j 小于 i的值 则进行替换
                if (arrays[j] < tempValue) {
                    arrays[i] = arrays[j];
                    arrays[j] = tempValue;

                    tempValue = arrays[i];
                }
            }
        }
    }
    private static void SwapPopSortMethod(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return ;
        }
        //获取数组长度
        int length = arrays.length;
        //双重循环冒泡处理
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i -1; j++) {
                //如果j 小于 i的值 则进行替换
                if (arrays[j] > arrays[j + 1]) {
                    int tempJValue = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tempJValue;
                }
            }
        }
    }
}
