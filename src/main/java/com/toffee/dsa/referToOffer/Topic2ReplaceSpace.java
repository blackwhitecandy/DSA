package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Date: Create in  2019/11/20
 */
public class Topic2ReplaceSpace {
    public static void main (String[] args) {
        System.out.println("----" + " ".charAt(0) + "++++");
        System.out.println(replaceSpace(new StringBuffer("  we    are  happy~ ")));
    }

    /**
     * 替换每个空格为20%
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        if (null == str) {
            return result.toString();
        }
        char[] charArray = str.toString().toCharArray();
        if (charArray != null  && charArray.length > 0) {
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == " ".charAt(0)) {
                    result.append("%20");
                } else {
                    result.append(charArray[i]);
                }
            }
        }

        return  result.toString();
    }
}
