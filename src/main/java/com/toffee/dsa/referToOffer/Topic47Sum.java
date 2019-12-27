package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Date: Create in 2019/12/26
 */
public class Topic47Sum {
    /**
     * sum n = (n + 1)n /2
     * @param n
     * @return
     */
    public int sumSolution(int n) {
        int sum = n;
        boolean result = ((n & 1) == 1) && ((sum += sumSolution(n - 1)) != 0);
        return sum;
    }

    /**
     * 位运算实现加法
     * @param m
     * @param n
     * @return
     */
    public int addSoulution(int m, int n) {
        return 0;
    }
}
