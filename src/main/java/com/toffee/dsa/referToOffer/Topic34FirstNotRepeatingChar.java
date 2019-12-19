package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * @Date: Create in 13:53 2019/12/19
 */
public class Topic34FirstNotRepeatingChar {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1c82e8cf713b4bbeb2a5b31cf5b0417c?f=discussion
     * 来源：牛客网
     *
     * 说一下解题思路哈，其实主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。
     * 首先用一个58长度的数组来存储每个字母出现的次数，
     * 为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
     * 而每个字母的index=int(word)-65，比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，
     * 最终遍历一遍字符串，找出第一个数组内容为1的字母就可以了，时间复杂度为O(n)
     * @param str
     * @return
     */
    public int firstNotRepeatingCharNice(String str) {
        int[] res = new int[58];
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (res[str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 采用字符串替换后 比较长度的方法  比如替换换过之后 长度就减了1  那么当前替换过的字符就是只出现过一次的字符
     * 然后再查询位置
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        //待处理的字符串
        String deal  = str;
        //字符串第一个字符
        String fc;
        while (true) {
            fc = deal.substring(0, 1);
            if ((deal.length() - (deal = deal.replaceAll(fc, "")).length()) == 1) {
                break;
            }
            fc = "";
        }
        if (!fc.isEmpty()) {
            return str.indexOf(fc);
        }
        return -1;
    }

    /**
     *
     * @param str
     * @return
     */
    public int firstNotRepeatingChar1(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        //待处理的字符串
        String deal  = str;
        //字符串第一个字符
        String firstString = "";
        String mutlString = "";
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length;
        while (left < right) {
            char currentChar = chars[left];
            //如果在复数字符串中已经出现当前字符串 则继续遍历
            if (mutlString.indexOf(currentChar) < 0) {
                //如果在第一次字符串中红已经包含此字符就 添加到复数字符串中，并从一次此字符串中移除当前字符
                if (firstString.indexOf(currentChar) >= 0) {
                    firstString = firstString.replaceAll(String.valueOf(currentChar), "");
                    mutlString += currentChar;
                } else {
                    //其余的情况，往一次字符串中添加当前字符
                    firstString += currentChar;
                }
            }
            left++;
        }
        if (!firstString.isEmpty()) {
            return str.indexOf(firstString.substring(0, 1));
        }
        return -1;
    }
}
