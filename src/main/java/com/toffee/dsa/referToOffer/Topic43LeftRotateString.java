package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * @Date: Create in 2019/12/24
 */
public class Topic43LeftRotateString {
    /**
     * 左移字符串
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString(String str,int n) {
        String result = "";
        if (str == null || str.isEmpty()) {
            return result;
        }

        //字符串拆分成字符数组
        char[] chars = str.toCharArray();
        int length = chars.length;
        // 防止n的长度 查过字符串的长度
        n = n % length;
        int lengthTemp = length + n;

        //遍历字符数组 拼凑字符串
        for (; n < lengthTemp; n++) {
            result += chars[n%length];
        }

        return result;
    }
}
