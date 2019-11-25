package com.toffee.dsa.referToOffer;

/**
 * @Author glz
 * @Description 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路 ： 把整数转化为二进制表示形式 计算1的个数 最后根据整数是否为负数判断是否加1
 * @ Date 2019-11-25 下午10:27
 */
public class Topic11NumberOfInt {
    public static void main (String[] args) {
//        System.out.println(numberOfInt(1));
//        System.out.println(numberOfInt(2));
//        System.out.println(numberOfInt(3));
//        System.out.println(numberOfInt(4));
//        System.out.println(numberOfInt(5));
//        System.out.println(numberOfInt(7));
        System.out.println(numberOfInt(-7));
        System.out.println(numberOfInt(7));
    }
    public static int numberOfInt(int n) {
        String binarystring = Integer.toBinaryString(n);
        char[] binaryCharArray = binarystring.toCharArray();
        int sum = 0;
        for (char binaryChar : binaryCharArray) {
            if (binaryChar == '1') {
                sum++;
            }
        }
        return sum;
    }
}
