package com.toffee.dsa.referToOffer;

import org.springframework.stereotype.Component;

/**
 * @Author: glz
 * @Description:
 * @Date: Create in 9:55 2019/12/19
 */
@Component
public class Topic33GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int factor2 = 0;
        int factor3 = 0;
        int factor5 = 0;
        for (int i = 1; i < index  ;i++) {
            uglyNums[i] = Math.min(uglyNums[factor2] * 2, Math.min(uglyNums[factor3] * 3, uglyNums[factor5] * 5));

            if (uglyNums[i] == uglyNums[factor2] * 2) {
                factor2++;
            }
            if (uglyNums[i] == uglyNums[factor3] * 3) {
                factor3++;
            }
            if (uglyNums[i] == uglyNums[factor5] * 5) {
                factor5++;
            }
        }
        return uglyNums[index - 1];
    }
}
