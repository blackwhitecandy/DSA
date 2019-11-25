package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *
 * n<=39
 * 考察递归的知识，可以递归调用函数 或者 循环累加来实现
 * @ Date 2019-11-24 下午8:31
 */
public class Topic7Fibonacci {
    public static void main (String[] args) {
        fibonacciRecursion(10);
    }
    public int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("valid num n ");
        }
        if (n == 0){return 0;}
        if (n == 1) {
            return 1;
        }
        int fpre1 = 0;
        int fpre2 = 1;
        int result = 0;
        int i = 2;
        while (i <= n) {
            result = fpre1 + fpre2;
            fpre1 = fpre2;
            fpre2 = result;
            i++;
        }
        return result;
    }
    public static int fibonacciRecursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("invalid num n :" + n);
        }
        if ( n < 2) {
            return n;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }
}
