package com.toffee.dsa.referToOffer;

import java.util.ArrayList;

/**
 * @Author glz
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @ Date 2019-11-30
 */
public class Topic19PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}};
        //int[][] matrix = {{1}, {2}};
        ArrayList<Integer> integerArrayList = printMatrix(matrix);
        for (int i : integerArrayList) {
            System.out.print(i + "-->");
        }
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        //判断矩阵是否为空
        if (matrix == null || matrix.length == 0) {
            return integerArrayList;
        }

        int minRowLength = 0;//最小行下标
        int minColLength = 0;//最小列下标
        int maxRowLength = matrix.length - 1;//矩阵行长度 最大行下标
        int maxColLength = matrix[0].length - 1;//矩阵列长度 最小行下标

        int row = 0;//行下标
        int column = 0;//列下标
        while (minColLength <= maxColLength && minRowLength <= maxRowLength) {
            //打印第一行 行号固定 列号递增
            while (column <= maxColLength) {
                integerArrayList.add(matrix[row][column++]);
            }
            //第一行已经被循环 所以行下标最小值 +1
            if (++minRowLength > maxRowLength) {
                break;
            }
            column--;//上面循环最后多做了++


            //行转列 打印最右侧一列 行号先切换到第二行
            while (++row <= maxRowLength) {
                integerArrayList.add(matrix[row][column]);
            }
            //最右侧一列 已经被循环  所以列长度 -1
            if (minColLength > --maxColLength) {
                break;
            }
            row--;//上面循环最后多做了++


            //列转行 打印最下面一行 列号先切换到倒数第二列
            while (--column >= minColLength) {
                integerArrayList.add(matrix[row][column]);
            }
            //最下面一行已经被遍历 所以最大行长度 -1
            if (minRowLength > --maxRowLength) {
                break;
            }
            column++;//上面循环最后多做了--

            //行转列 打印最左侧一列 行号先切换到倒数第二行
            while (--row >= minRowLength) {
                integerArrayList.add(matrix[row][column]);
            }
            row++;//上面循环最后多做了--
            minColLength++; //最左侧一列已经被遍历 所以最小行下标 +1
            column++;//换到第二列
        }
        return integerArrayList;
    }
}
