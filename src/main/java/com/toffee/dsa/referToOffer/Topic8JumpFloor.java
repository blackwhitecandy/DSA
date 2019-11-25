package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * 分析： 其实就是个Fibonacci数列
 * @ Date 2019-11-24 下午9:02
 */
public class Topic8JumpFloor {
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        } else {
            int targetOne = 1;
            int targetTwo = 2;
            int i = 3;
            int count = 0;
            while (i++ <= target) {
                count = targetOne + targetTwo;
                targetOne = targetTwo;
                targetTwo = count;
            }
            return count;
        }

    }
}
