package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @Date: Create in 2019/12/24
 */
public class Topic44ReverseSentence {
    /**
     * 翻转单词顺序，以空格区分单词  空格的ASCII码是32
     *
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        String resultStr = "";
        //单词的左下标
        int left = 0;
        int length = str.length();
        //遍历每个字符
        for (int i = 0; i < length; ) {
            //如果当前字符不是空字符 遍历当前单词到结尾
            while (i < length && str.charAt(i) != 32) {
                //left为-1 给left赋值 继续循环
                if (left == -1) {
                    left = i;
                }
                i++;
            }
            //如果当前字符是空格
            if (i < length && str.charAt(i) == 32) {
                //如果left不是-1 则代表前一字符是个终结字符
                resultStr = str.substring(left, i) + " " + resultStr;
                left = -1;
                i++;
            }

        }
        resultStr = str.substring(left) + " " + resultStr;

        return resultStr.substring(0, resultStr.length() - 1);
    }
}
