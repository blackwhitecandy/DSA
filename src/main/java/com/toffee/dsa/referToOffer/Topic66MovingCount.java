package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @Date: Create in 2020/1/9
 */
public class Topic66MovingCount {
    /**
     * 从0.0开始 依照 上 右的顺序遍历可以结束 以为往下和往左都是重复的
     * @param threshold 负载因子
     * @param rows 行数限制
     * @param cols 列数限制
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        //判断三个参数是否合法
        if (threshold < 1 || rows < 1 || cols < 1) {
            return 0;
        }
        //是否走过的路径记录  true走过  false没走过  走的方格不需要继续遍历
        boolean[][] path = new boolean[rows][cols];

        //遍历所有路径 计算能够走过的方格数目
        return checkPath(threshold, rows, cols, 0, 0, path);
    }

    /**
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param currentRow
     * @param currentCol
     * @param path
     */
    private int checkPath(int threshold, int rows, int cols, int currentRow, int currentCol, boolean[][] path) {
        if (currentRow >= rows || currentCol >= cols) {
            return 0;
        }
        //判断方格行坐标和列坐标的数位之和是否大于负载因子
        if (checkNum(threshold, currentRow, currentCol)) {
            //判断当前方格是否走过 走过的直接返回
            if (path[currentRow][currentCol]) {
                return 0;
            } else {
                path[currentRow][currentCol] = true;
                //没走过的方格 计数+1
                //向上和向右遍历
                int upCount = checkPath(threshold, rows, cols, currentRow + 1, currentCol, path);
                int rightCount = checkPath(threshold, rows, cols, currentRow, currentCol + 1, path);
                return upCount + rightCount + 1;
            }
        }
        return 0;
    }

    /**
     * 判断行坐标和列坐标的数位之和是否大于负载因子 true小于等于
     * @param threshold
     * @param currentRow
     * @param currentCol
     * @return
     */
    public boolean checkNum(int threshold, int currentRow, int currentCol) {
        int numCount = 0;
        while (currentRow > 0) {
            numCount += currentRow % 10;
            currentRow = currentRow/10;
        }

        while (currentCol > 0) {
            numCount += currentCol % 10;
            currentCol = currentCol/10;
        }

        if (numCount > threshold) {
            return false;
        }

        return true;
    }
}
