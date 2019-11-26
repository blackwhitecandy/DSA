package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
 * 考察知识点 数学以及代码完整性; 思路 ： for循环 相乘  注意0值的判断
 * @ Date 2019-11-26 下午10:04
 */
public class Topic12Power {
    public static void main (String[] args) {
        System.out.println(power(1.2, 4));
        System.out.println(power(0, 4));
        System.out.println(power(1.2, 0));
        System.out.println(power(1.2, -4));
        System.out.println(power(-1.2, 4));
    }
    public static double power(double base, int exponent) {
        //判断base为0  直接返回0
        if (base == 0.0) {
            return 0;
        }
        //判断exponent是否为0 以及正负值
        double result = 1;
        if (exponent == 0) {//为0 直接返回1
            return 1;
        } else if (exponent > 0) {//大于0  遍历相乘求值
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        } else {//小于0  遍历求值 最后要被1 相除
            for (int i = 0; i < -exponent; i++) {
                result *= base;
            }
            result = 1/result;
        }
        return result;
    }
}
