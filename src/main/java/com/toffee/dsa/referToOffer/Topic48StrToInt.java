package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * ASCII 码 48-57 对应0-9
 * +（加号)的ASCII 为43
 * - （减号）的ASCII为45
 * @Date: Create in 2019/12/27
 */
public class Topic48StrToInt {
    public int strToInt(String str) {
        int result = 0;
        //如果字符串为空，或者字符串开头字符小于1或者大于9 都不是一个合法的数值
        if (str == null || str.isEmpty()) {
            return 0;
        }
        //判断开头字符是否是加减号或者1-9的数字  是的话 继续处理 否则直接返回0
        char headChar = str.charAt(0);
        int startIndex = 0;
        boolean isPositiveInteger = true;
        if ((headChar > 48 && headChar <= 57) || headChar == 43 || headChar == 45) {
            //判断是会否+-号  是的话 从字符的第二位开始计算数值
            if (headChar == 43 || headChar == 45) {
                startIndex = 1;
                if (headChar == 45) {
                    isPositiveInteger = false;
                }
            }
            //遍历每个字符判断是否是合法的数值 是的话原值*10 + cur
            for (; startIndex < str.length(); startIndex++) {
                char cur = str.charAt(startIndex);
                if (cur >= 48 && cur <= 57) {
                    //如果result*10 之前大于 max_value /10  那么*10之后肯定超出范围.如果加号等于最大值/10则还需要判断 个数位的数值大小
                    //并分正负数去判断
                    if (result > Integer.MAX_VALUE / 10) {
                        return 0;
                    } else if (result == Integer.MAX_VALUE/10) {
                        //如果个位数大于8 或者 是正数的时候大于7都是溢出
                        if ((cur - '0') > 8 || (isPositiveInteger && (cur - '0') > 7)) {
                            return 0;
                        }
                    }
                    result = result * 10 + (cur - '0');
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
        //判断是否是负数  如果是的话 返回补码 = 反码 + 1
        if (isPositiveInteger) {
            return result;
        } else {
            return ~result + 1;
        }
    }
}
