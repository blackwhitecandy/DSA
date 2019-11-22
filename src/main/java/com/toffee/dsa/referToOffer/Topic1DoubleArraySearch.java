package com.toffee.dsa.referToOffer;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

/**
 * @Author: glz
 * @Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Date: Create in 9:23 2019/11/19
 */
public class Topic1DoubleArraySearch {
    public static void main(String[] args) {
//        int array[] = makeOneDimensionalArray(15);
//        for (int i : array) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//        orderArray(array, 0, array.length -1);
//        for (int i : array) {
//            System.out.print(i + "  ");
//        }

        int[][] twoDimensionalArray = new int[20][];
        for (int i = 0; i < 20; i++) {
            int array[] = makeOneDimensionalArray(20);
            orderArray(array, 0, array.length - 1);
            twoDimensionalArray[i] = array;
        }
        for (int[] oneDimensionalArray : twoDimensionalArray) {
            for (int loopInt : oneDimensionalArray) {
                System.out.print((loopInt + "   ").substring(0, 4));
            }
            System.out.println();
        }
        int target = 72;

        find(target, twoDimensionalArray);
    }

    /**
     * 生成随机一维数组
     *
     * @param length 数组长度
     * @return
     */
    public static int[] makeOneDimensionalArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int nextInt = 0;
            do {
                nextInt = random.nextInt(100);
            } while (ArrayUtils.contains(array, nextInt));

            array[i] = nextInt;
        }
        return array;
    }

    /**
     * 排序一维数组 从小到大
     *
     * @param array
     * @return
     */
    public static void orderArray(int[] array, int startIndex, int endIndex) {
        //数组为空或者长度小于等于1  直接返回
        if (startIndex >= endIndex) {
            return ;
        }
        int mid = getFastSortNodeIndex(array, startIndex, endIndex);
        orderArray(array, startIndex, mid - 1);
        orderArray(array, mid + 1, endIndex);
    }

    /**
     * 获取快速排序节点下标
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int getFastSortNodeIndex(int[] array, int startIndex, int endIndex) {

        int flagInt = array[startIndex]; //获取目标元素  从下标0开始
        while (startIndex < endIndex) {
            //如果尾元素大于目标元素 则尾下标递减 不进行处理 直到找到小于目标元素的元素   递归处理
            while (startIndex < endIndex) {
                if (array[endIndex] >= flagInt) {
                    endIndex--;
                } else {
                    //让头元素值等于找到的小于目标元素的尾元素  同时头元素下标加一
                    array[startIndex] = array[endIndex];
                    break;
                }
            }

            //如果头元素小于目标元素 则头下标递增 不进行处理   直到找到大于目标元素的元素   递归处理
            while (startIndex < endIndex) {
                if (array[startIndex] < flagInt) {
                    startIndex++;
                } else {
                    array[endIndex] = array[startIndex];
                    break;
                }
            }
        }
        array[startIndex] = flagInt;
        return startIndex;
    }
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增1的顺序排序，每一列都按照从上到下递增1的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean findIncrementArray(int target, int[][] array) {
        int length = array.length;//获取二维数组长度
        int arrayLength = array[0].length;//获取一维数组长度
        int minNum = array[0][0];//获取数组中的最小值，即数组左上角元素
        int maxNum = array[length - 1][arrayLength - 1];//获取数组中最大元素 即数组右下角元素
        if (target >= minNum && target <= maxNum) {
            return true;
        }
        return false;
    }

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int length = array.length;//获取二位数组长度
        for (int i = 0; i < length; i++) {
            int[] oneDimensionalArray = array[i];
            if (oneDimensionalArray == null || oneDimensionalArray.length == 0) {
                continue;
            }
            int oneDimensionalArrayLength = oneDimensionalArray.length;
            //如果一维数组的头元素大于目标整数或者尾元素小于目标整数则 该一维数组不包含目标整数
            if (oneDimensionalArray[0] > target || oneDimensionalArray[oneDimensionalArrayLength - 1] < target) {
                continue;
            } else {
                //如果折半查找找到元素 返回true
                if (binarySearch(target, oneDimensionalArray, 0, oneDimensionalArrayLength) != -1) {
                    System.out.println("i index : " + i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 折半查找
     *
     * @param target     目标整数
     * @param array      有序数组
     * @param startIndex 开始下标
     * @param endIndex   结束下标
     * @return
     */
    public static int binarySearch(int target, int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (target == array[mid]) {
            System.out.println("j index : " + mid);
            return mid;
        } else if (target > array[mid]) {
            return binarySearch(target, array, mid + 1, endIndex);
        } else {
            return binarySearch(target, array, startIndex, mid - 1);
        }
    }
}
