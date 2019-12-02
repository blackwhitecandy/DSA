package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
 * 考察知识点 数学以及代码完整性; 思路 ： for循环 相乘  注意0值的判断
 * @ Date 2019-11-26
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



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1a834e5e3e1a4b7ba251417554e07c00?f=discussion
     *     来源：牛客网
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public double Power(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);
    }
}
