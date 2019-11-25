package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * @ Date 2019-11-24 下午5:11
 */
public class Topic6MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int length = array.length;
        for (int i = length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return array[0];
    }

    public int minNumberInRotateArrayNice(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int i = 0;
        int j = array.length;
        int mid = 0;
        while (i < j) {
            mid = (i + j) >> 1;
            if (array[mid] > array[i]) {
                i = mid;
            } else if (array[mid] < array[i]) {
                j = mid;
            } else {
                i++;//避开 1 0  1  1  1   这种情况 即重复值情况的发生
            }
        }
        return array[i];
    }
}
