package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author: glz
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 其实就是要排序，比如1开头的整数放最前面，2次之，以此类推
 * 如果开头数字相同的要比较第二位 第二位为空的可视为是第一位数字 小的放前边
 * @Date: Create in 10:49 2019/12/19
 */
public class Topic32PrintMinNumber {

    public String PrintMinNumber(int[] numbers) {
        ArrayList<String> numberList = new ArrayList<>();
        for (int i : numbers) {
            numberList.add(String.valueOf(i));
        }
        numberList.sort((t1, t2) -> {
            String str1 = t1 + "" + t2;
            String str2 = t2 + "" + t1;
            return str1.compareTo(str2);
        });
        return numberList.toString().replaceAll(", ", "")
                .replaceAll("\\[", "")
                .replaceAll("]", "");
    }
}
