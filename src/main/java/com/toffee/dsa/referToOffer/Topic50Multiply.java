package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 * @Date: Create in 2019/12/27
 */
public class Topic50Multiply {
    /**
     * 分析 B[i] 的值分为两部分的乘积  一个是a[0]...a[i-1]  另一个是a[i+1]...a[n-1]
     * @param A 输入的数组
     * @return 返回构造的乘积数组
     */
    public int[] multiply(int[] A) {
        if (A == null) {
            return null;
        }

        int length = A.length;
        //构造的乘积数组
        int[] B = new int[length];
        //A[0] - A[i-1]的乘积数组
        int[] prev = new int[length];
        prev[0] = 1;

        //a[i+1]...a[n-1]的乘积
        int[] next = new int[length];
        next[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            prev[i] = prev[i - 1] * A[i -1];
            next[length - 1 - i] = next[length - i] * A[length - i];
        }

        for (int i = 0; i < length; i++) {
            B[i] = prev[i] * next[i];
        }
        return B;
    }
}
