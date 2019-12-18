package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @Date: Create in 14:57 2019/12/18
 */
public class Topic30FindGreatestSumOfSubArray {
    public static void main (String[] args) {
        int[] array = {1,-2,6,-3,-2,7,-15,1,2,2};
        int length = array.length;
        //定义最大子序列和为0
        int greatestSum = array[0];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            //如果sum和当前元素累加仍然大于0 则继续
            if ((sum += array[i]) > 0 || sum > greatestSum) {
                //判断当前的累加和和最大子序列和的大小进行比较 并替换
                if (sum > greatestSum) {
                    greatestSum = sum;
                }
            } else {
                //当累加和小于0的时候 //sum清零 继续下一轮的累加
                sum = 0;
            }
        }
        System.out.println(findGreatestSumOfSubArray(array));
    }
    public static int findGreatestSumOfSubArray(int[] array) {
        int length = array.length;
        //定义最大子序列和为0
        int greatestSum = array[0];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            //如果sum和当前元素累加仍然大于0 则继续
            if ((sum += array[i]) > 0 || sum > greatestSum) {
                //判断当前的累加和和最大子序列和的大小进行比较 并替换
                if (sum > greatestSum) {
                    greatestSum = sum;
                }
            } else {
                //当累加和小于0的时候 //sum清零 继续下一轮的累加
                sum = 0;
            }
        }
        return greatestSum;
    }
}
