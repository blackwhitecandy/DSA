package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author: glz
 * @Description: 小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @Date: Create in 2019/12/23
 */
public class Topic41FindContinuousSequence {
    /**
     * 从1开始到n的和为 n(n - 1)/2  根据此来判断第一个连续序列
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        //找到第一个序列的最小值和最大值
        int left = 1;
        int right = 2;

        //如果当前连续序列和不等于sum 继续遍历
        while (left < right && right < sum) {

            //如果当前序列和小于sum 则right右移
            while (right < sum && ((right - left + 1) * (right + left)) >> 1 < sum) {
                right++;
            }

            //如果当前序列和等于sum保存到当前序列
            if (((right - left + 1) * (right + left)) >> 1 == sum) {
                ArrayList<Integer> sequenceList = new ArrayList<>();
                int leftTemp = left;
                for (; leftTemp <= right; leftTemp++) {
                    sequenceList.add(leftTemp);
                }
                resultList.add(sequenceList);

                right++;
                left++;
            }

            //如果当前序列和大于sum  则left右移
            while(left < right && ((right - left + 1) * (right + left)) >> 1 > sum) {
                left++;
            }
        }
        return resultList;
    }

}
