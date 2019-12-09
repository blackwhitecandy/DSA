package com.toffee.dsa.algorithm.sort;

/**
 * @Author: glz
 * @Description: 快速排序
 * @Date: Create in 15:11 2019/10/31
 */
public class QuicklySort {
    //插入排序数组长度阈值   可根据实际情况而定
    private static int MAX__LENGTH_INSRT_SORT = 8;

    public static void main(String[] args) {
        int[] array = {43, 3, 4, 9, 45, 23, 110, 6, 73, 125, 34, 22, 88, 99, 51};
        //int[] arrays = {43,3,4,9,45};
        QuickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 快速排序优化  大量数据用快速排序  少量数据用插入排序
     *
     * @param arrays
     * @param low
     * @param high
     */
    private static void quickSort(int[] arrays, int low, int high) {
        if (low >= high) {
            return;
        }
        //如果高位减去低位 长度差值大于阈值就用快速排序 否则就用插入排序
        if ((high - low) >= MAX__LENGTH_INSRT_SORT) {
            int pivot = 0;
            pivot = partition(arrays, low, high);//每次排序一个元素 默认排序第一个元素 并返回该元素最后的下标

            //根据该坐标把数组分成两部分  递归执行快速排序的处理
            QuickSort(arrays, low, pivot - 1);//数组下标前半部分
            QuickSort(arrays, pivot + 1, high);//数组下标后半部分
        } else {
            //此处插入排序还可以优化，传入low和high进行针对性排序
            InsertSort.insertSort(arrays);
        }
    }

    /**
     * 划分获取枢纽值
     * 优化  取枢纽值的时候 有可能是获取到的一个较小或者较大的关键字这样就导致根据枢纽值分隔开的两部分数组大小不均衡
     * 可采用三数取中的方法 取第一个、最后一个和中间元素的中间值来作为枢纽值
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partitionNice(int[] array, int low, int high) {
        int mid = (low + high)/2;//中间下标
        //如果低位元素大于高位元素 就交换  保证低位元素较小
        if (array[low] > array[high]) {
            SortUtil.swapArray(array, low, high);
        }
        //如果中间元素大于高位元素 就交换 保证中间元素较小
        if (array[mid] > array[high]) {
            SortUtil.swapArray(array, mid, high);
        }
        //从低位元素和中间元素中 选择较大的  两小取其大  放在低位位置  这样低位元素就是三数中间大小元素
        if (array[mid] > array[low]) {
            SortUtil.swapArray(array, low, mid);
        }
        int pivotKey = array[low];//取数组第一个值作为枢纽值
        //遍历处理所有元素  一直到比flag小的元素都在下标i之前   比flag小的元素都在下标i之后
        while (low < high) {
            //倒序 比较 直到找到一个小于枢纽值的元素
            while (low < high && array[high] >= pivotKey) {
                high--;
            }
            //把小于枢纽值的元素 交换到前边low的位置 并把low+1
            array[low] = array[high];

            //正序 比较  直到找到一个比枢纽值大的元素
            while (low < high && array[low] <= pivotKey) {
                low++;
            }
            //把大于枢纽值的元素 交换到后边high的位置 并把high+1
            array[high] = array[low];
        }

        //low下标设置元素 pivotKey  返回low
        array[low] = pivotKey;
        return low;
    }

    /**
     * 快速排序
     *
     * @param arrays
     * @param i
     * @param high
     */
    private static void QuickSort(int[] arrays, int i, int high) {
        if (i >= high) {
            return;
        }
        int pivot = 0;
        pivot = partition(arrays, i, high);//每次排序一个元素 默认排序第一个元素 并返回该元素最后的下标
        //根据该坐标把数组分成两部分  递归执行快速排序的处理
        QuickSort(arrays, i, pivot - 1);//数组下标前半部分
        QuickSort(arrays, pivot + 1, high);//数组下标后半部分
    }

    /**
     * 划分获取枢纽值
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] array, int low, int high) {
        int pivotKey = array[low];//取数组第一个值作为枢纽值
        //遍历处理所有元素  一直到比flag小的元素都在下标i之前   比flag小的元素都在下标i之后
        while (low < high) {
            //倒序 比较 直到找到一个小于枢纽值的元素
            while (low < high && array[high] >= pivotKey) {
                high--;
            }
            //把小于枢纽值的元素 交换到前边low的位置 并把low+1
            array[low] = array[high];

            //正序 比较  直到找到一个比枢纽值大的元素
            while (low < high && array[low] <= pivotKey) {
                low++;
            }
            //把大于枢纽值的元素 交换到后边high的位置 并把high+1
            array[high] = array[low];
        }

        //low下标设置元素 pivotKey  返回low
        array[low] = pivotKey;
        return low;
    }


}
