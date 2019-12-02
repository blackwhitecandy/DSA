package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：考察递归   f(n) = f(n-1) + 2*f(n-2)              自己想错了  当在一个2×2的矩形中摆放时   横竖都算一种方法 所以最后的为f(n-2)
 * @ Date 2019-11-25
 */
public class Topic10RectCover {
    public int rectcover(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("invalid argument target : " + target);
        } else if (target <= 2) {
            return target;
        } else {
            return rectcover(target - 1) + rectcover(target - 2);
        }
    }
}
