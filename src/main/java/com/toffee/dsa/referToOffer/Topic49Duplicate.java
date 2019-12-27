package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @Date: Create in 2019/12/27
 */
public class Topic49Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     *
     * @param numbers an array of integers
     * @param length the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     *                    Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     * @return true if the input is valid, and there are some duplications in the array number otherwise false
     *          这里要特别注意~返回任意重复的一个，赋值duplication[0]
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        //如果数组是null或者为空 返回false
        if (numbers == null || numbers.length <= 0 ) {
            return false;
        }
        //如果数组长度和输入的长度length不匹配 直接返回false
        if (numbers.length != length) {
            return false;
        }
        //创建一个重复出现的数组 下标代表重复出现的数值
        int[] duplicateNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            //如果当前数 作为下标 在重复数组中存储的值为-1 则代表应出现过 可以返回
            if (duplicateNumbers[numbers[i]] == -1) {
                duplication[0] = numbers[i];
                return true;
            } else {
                duplicateNumbers[numbers[i]] = -1;
            }
        }

        return false;
    }
}
