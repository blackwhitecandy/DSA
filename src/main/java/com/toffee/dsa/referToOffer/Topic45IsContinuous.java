package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @Date: Create in 2019/12/24
 */
public class Topic45IsContinuous {
    /**
     * 判断输入的数组能否组成顺子
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers) {
        //如果数组为null 或者 长度为0  则返回false
        if (numbers == null || numbers.length < 2) {
            return false;
        }
        int length = numbers.length;

        //因为数组长度有限，可以直接使用插入排序
        for (int i = 1; i < length; i++) {
            //如果前一元素大于当前元素 则遍历让当前元素前移至合适的位置
            if (numbers[i - 1] > numbers[i]) {
                int currentNum = numbers[i];
                int j = i - 1;
                while (j >= 0 && numbers[j] > currentNum) {
                    numbers[j + 1] = numbers[j];
                    j--;
                }
                numbers[j + 1] = currentNum;
            }
        }

        int zeroSum = 0;
        //循环判断 排序后的数组是否相邻元素 相差1
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == 0) {
                zeroSum++;
                continue;
            }
            int numDiff = numbers[i + 1] - numbers[i];
            if (numDiff == 0 || numDiff - 1 - zeroSum > 0) {
                return false;
            } else if (numDiff != -1) {
                //判断还剩几个0  如果剩下0个一下的话 就代表组不成顺子了
                zeroSum = zeroSum - (numDiff - 1);
                if (zeroSum < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
