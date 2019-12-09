package com.toffee.dsa.algorithm.sort;

/**
 * @Author: glz
 * @Description: 冒泡排序   基于交换排序  每次比较后都做交换
 * @Date: Create in 15:00 2019/11/1
 */
public class PopSort {
    public static void main(String[] args) {
        int[] arrays = new int[100];
        for (int i = 0; i < 100; i++) {
            arrays[i] = (int) (Math.random() * 1000 %1000 + 1);
        }
        //int[] arrays = {43,3,4,9,45};
        popSortMethod3(arrays);
        for (int i : arrays) {
            System.out.print(i + " < ");
        }
    }


    /**
     * 最基础的冒泡排序 双重循环 时间复杂度为O(n^2)
     * 其实就是最简单的交换排序  算不得冒泡  而且会把次小值交换到靠后的位置去 比较浪费
     * @param arrays
     */
    private static void popSortMethod1(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return ;
        }
        //获取数组长度
        int length = arrays.length;
        //双重循环冒泡处理
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //如果j 小于 i的值 则进行替换
                if (arrays[i] > arrays[j]) {
                    int tempJValue = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = tempJValue;
                }
            }
        }
    }


    /**
     * 冒泡排序 优化 之前循环做的比较交换都保留了下来，之后的循环就可以少处理很多
     * 9->1->5->8->2
     * 循环一轮结束后变为1->9->2->5->8
     * 这样不仅1到了第一位 ，而且2也往前提升了很多位置
     * @param arrays
     */
    private static void popSortMethod2(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return ;
        }
        //获取数组长度
        int length = arrays.length;
        //双重循环冒泡处理 i升序
        for (int i = 0; i < length; i++) {
            //j倒序从后往前处理
            for (int j = length - 2; j > i; j--) {
                //两两比较如果前一元素大于后一元素 就交换。这样一轮循环下来，较小的元素都会往前移动
                if (arrays[j] > arrays[j + 1]) {
                    int tempValue = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tempValue;
                }
            }
        }
    }

    /**
     * 循环一轮结束后，可能已经是完全排序了，但是接下来还要继续判断，浪费
     * 例如4-5-6-7-8-9-1一次排序后就完全有序了 接下来还要循环判断
     * 继续优化 加上一个循环结束的标志flag
     * @param arrays
     */
    private static void popSortMethod3(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return ;
        }
        //获取数组长度
        int length = arrays.length;
        boolean flag = true;//排序完成结束标志
        //双重循环冒泡处理 i升序
        for (int i = 0; i < length && flag; i++) {
            flag = false;
            //j倒序从后往前处理
            for (int j = length - 2; j > i; j--) {
                //两两比较如果前一元素大于后一元素 就交换。这样一轮循环下来，较小的元素都会往前移动
                if (arrays[j] > arrays[j + 1]) {
                    int tempValue = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tempValue;
                    //只要还有交换就设置为true，否则一轮循环下来都没有交换处理的话 就代表数组已经是有序的了，就可以结束了
                    flag = true;
                }
            }
        }
    }
}
