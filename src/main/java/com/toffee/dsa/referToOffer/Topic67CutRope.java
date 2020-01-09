package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 给你一根长度为n的绳子，
 * 请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 *      输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 *      输出答案。
 * 示例1
 *  输入
 *      8
 *  输出
 *      18
 * @Date: Create in 2020/1/9
 */
public class Topic67CutRope {
    /**
     * 贪心算法  从小开始算起 认为每一步都获得了最优解，这样到最后就获得了最优解       其实有可能不是最优解
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        int[] maxProduct = new int[target];
        maxProduct[0] = 1;
        maxProduct[1] = 2;
        //双重循环求值
        for (int i = 3; i <= target; i++) {
            int maxProductNum = 0;
            int currentTarget = i - 1;
            //遍历循环求出当前target下的最大乘积值
            for (int j = 1; j <= currentTarget; j++) {
                if (maxProduct[currentTarget - j] * j > maxProductNum) {
                    maxProductNum = maxProduct[currentTarget - j] * j;
                }
            }
            maxProduct[i - 1] = maxProductNum;
        }
        return maxProduct[target - 1];
    }
}
