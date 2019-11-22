package com.toffee.dsa.algorithm;

/**
 * @Author: glz
 * @Description: 快速排序
 * @Date: Create in 15:11 2019/10/31
 */
public class QuicklySort {
    public static void main(String[] args) {
        int[] arrays = {43, 3, 4, 9, 45, 23, 110, 6, 73, 125, 34, 22, 88, 99, 51};
        //int[] arrays = {43,3,4,9,45};
        QuickSort(arrays, 0, arrays.length - 1);
        for (int i : arrays) {
            System.out.println(i);
        }
    }

    /**
     * 快速排序
     *
     * @param arrays
     * @param i
     * @param length
     */
    private static void QuickSort(int[] arrays, int i, int length) {
        if (i >= length) {
            return;
        }
        int mid = 0;
        mid = getMid(arrays, i, length);//每次排序一个元素 默认排序第一个元素 并返回该元素最后的下标
        //根据该坐标把数组分成两部分  递归执行快速排序的处理
        QuickSort(arrays, i, mid - 1);//数组下标前半部分
        QuickSort(arrays, mid + 1, length);//数组下标后半部分
    }

    private static int getMid(int[] arrays, int i, int length) {
        int tempValue = arrays[i];//取数组第一个值作为分隔的依据 flag
        //遍历处理所有元素  一直到比flag小的元素都在下标i之前   比flag小的元素都在下标i之后
        while (i < length) {
            //如果后边有一个元素 小于 flag数据  则替换到前边去 找不到则length-- 继续查找
            while (i < length) {
                if (arrays[length] < tempValue) {
                    arrays[i] = arrays[length];
                    break;
                }
                length--;
            }

            //从前到后处理 找到一个比flag大的数组  放置到下标length中去
            while (i < length) {
                if (arrays[i] > tempValue) {
                    arrays[length] = arrays[i];
                    break;
                }
                i++;
            }
        }

        //i下标设置元素 flag  返回i
        arrays[i] = tempValue;
        return i;
    }


}
