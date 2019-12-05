package com.toffee.dsa.referToOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: glz
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 需要分解问题 先去重获取所有字母 然后
 * @Date: Create in 2019/12/5
 */
public class Topic27Permutation {
    public static void main(String[] args) {
        String str = "1213";
        ArrayList<String> resultList = permutationDictionary(str);
        for (String string : resultList) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> resultList = new ArrayList<>();
        //判断字符串是否为空
        if (null == str || str.length() == 0) {
            return resultList;
        }
        char[] allCharArray = str.toLowerCase().toCharArray();
        //初始化结果list包含第一个字母的字符串
        resultList.add(String.valueOf(allCharArray[0]));
        //如果字母list只包含一个字母直接返回
        if (allCharArray.length == 1) {
            return resultList;
        }

        //遍历插入
        for (int i = 1; i < allCharArray.length; i++) {
            insertCharacter(String.valueOf(allCharArray[i]), resultList);
        }
        //排序
        resultList.sort((o1, o2) -> o1.compareTo(o2));
        return resultList;
    }

    /**
     * 插入字符串
     *
     * @param charStr    待插入字母
     * @param resultList 待插入字符串
     * @return
     */
    private static void insertCharacter(String charStr, ArrayList<String> resultList) {
        ArrayList<String> preStringList = new ArrayList<>(resultList);
        for (String str : preStringList) {
            resultList.addAll(remakeString(str, charStr));
            resultList.remove(0);
        }
    }

    /**
     * 给字符串每个位置都添加字符ch生成新的字符串 然后返回包含所有新字符串的list 并去重
     *
     * @param str
     * @param charStr
     * @return
     */
    public static ArrayList<String> remakeString(String str, String charStr) {
        ArrayList<String> strList = new ArrayList<>();
        int length = str.length();
        for (int i = 0; i <= length; i++) {
            String lastStr = str.substring(0, i) + charStr + str.substring(i, length);
            //判断结果list中是否存在相同的 存在相同的 就不添加了
            if (!strList.contains(lastStr)) {
                strList.add(lastStr);
            }

        }
        return strList;
    }

    public static ArrayList<String> permutation2(String str) {
        ArrayList<String> resultList = new ArrayList<>();
        //判断字符串是否为空
        if (null == str || str.length() == 0) {
            return resultList;
        }
        //获取字母list
        char[] allCharArray = str.toLowerCase().toCharArray();
        resultList.add(String.valueOf(allCharArray[0]));

        int length;//当前排列的字符串的长度
        String currentString;//当前字符串
        char charStr;//下一个待排列的字符
        String lastStr;//新的排列字符串
        while ((length = (currentString = resultList.get(0)).length()) < allCharArray.length) {
            charStr = allCharArray[length];//获取下一个字符
            //循环在当前字符串的所有缝隙插入下一个字符 包含两端的位置 并且去重
            for (int i = 0; i <= length; i++) {
                lastStr = currentString.substring(0, i) + charStr + currentString.substring(i, length);
                //判断结果list中是否存在相同的 存在相同的 就不添加了
                if (!resultList.contains(lastStr)) {
                    resultList.add(lastStr);
                }
            }
            //移除当前结果字符串 因为已经根据当前字符串生成新的子串
            resultList.remove(0);
        }
        //排列所有字符串
        resultList.sort(((o1, o2) -> o1.compareTo(o2)));
        return resultList;
    }


    /**
     * 字典序全排列
     *
     * @return
     */
    public static ArrayList<String> permutationDictionary(String str) {
        ArrayList<String> resultList = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return resultList;
        }
        //获取所有字符，并且排序
        char[] allCharArray = str.toLowerCase().toCharArray();
        Arrays.sort(allCharArray);
        resultList.add(String.valueOf(allCharArray));

        int length = allCharArray.length;
        int leftIndex;//倒叙第一个变小的下标 + 1
        int rightIndex;//比leftIndex大的最后一个元素的下标 - 1
        while (true) {
            leftIndex = length - 1;
            //倒叙找到第一个变小的元素 left是其下标+1
            while (leftIndex >= 1 && allCharArray[leftIndex - 1] >= allCharArray[leftIndex]) {
                leftIndex--;
            }
            //如果倒叙找到第一个变小节点都没找到 就结束
            if (leftIndex == 0) {
                break;
            }
            rightIndex = leftIndex;
            //找到变小值后，找此值后边最后一个大值（大于变小值的值）
            while (rightIndex < length && allCharArray[rightIndex] > allCharArray[leftIndex - 1]) {
                rightIndex++;
            }
            //交换找到的两个值
            swapArray(allCharArray, leftIndex - 1, rightIndex - 1);

            //升序排列leftindex开始的所有元素
            popSort(allCharArray, leftIndex);

            //添加新的全排列进结果list
            resultList.add(String.valueOf(allCharArray));
        }
        return resultList;
    }

    /**
     * 冒泡排序leftindex 开始的所有元素
     *
     * @param charArray
     * @param leftIndex
     */
    private static void popSort(char[] charArray, int leftIndex) {
        int length = charArray.length;
        boolean swapFlag;//交换flag
        for (int i = leftIndex; i < length; i++) {
            swapFlag = true;//每次初始化为true  如果第二层循环 一遍 结束 还是true就代表没有可以交换的元素了，也就是说已经是有序的了
            //倒叙遍历小的数据往上冒泡
            for (int j = length - 1; j > i; j--) {
                //如果前一元素 大于 后一元素 就交换
                if (charArray[j - 1] > charArray[j]) {
                    swapArray(charArray, j - 1, j);
                    swapFlag = false;
                }
            }
            //如果有序 提前结束
            if (swapFlag) {
                break;
            }
        }

    }

    /**
     * 交换数组中两个下标的位置
     *
     * @param allCharArray
     * @param leftIndex
     * @param rightIndex
     */
    private static void swapArray(char[] allCharArray, int leftIndex, int rightIndex) {
        char temp = allCharArray[rightIndex];
        allCharArray[rightIndex] = allCharArray[leftIndex];
        allCharArray[leftIndex] = temp;
    }
}
