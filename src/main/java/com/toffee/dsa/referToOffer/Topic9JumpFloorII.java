package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路 f(n) = f(n-1) + f(n-2) + ... + f(2) + f(1)
 * @ Date 2019-11-25
 */
public class Topic9JumpFloorII {
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else {
            int sum = 1;
            while  (target > 1) {
                sum += jumpFloor(target - 1);
                target--;
            }
            return sum;
        }
    }
}
