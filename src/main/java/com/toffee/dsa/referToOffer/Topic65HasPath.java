package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @Date: Create in 2020/1/8
 */
public class Topic65HasPath {
    /**
     * 矩阵中是否包含字符串的路径
     * 回溯法 新建一个数组存放是否走过 从开始字符开始查找 判断周围的字符有没有符合第二个字符的  符合的重复此动作  走过的路径不能重复走
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) {
            return false;
        }
        boolean[] path = new boolean[matrix.length];
        int i = 0;
        int j = 0;
        int currentIndex = 0;
        while (i < rows) {
            while (j < cols) {
                //获取一维数组中的当前下标
                currentIndex = i * cols + j;
                //如果当前字符等于开头的字符 判断是否含有整个字符路径
                if (matrix[currentIndex] == str[0]) {
                    if (hasStrPath(matrix, rows, cols, str, i, j, path, 0)) {
                        return true;
                    }
                }
                j++;
            }
            j = 0;
            i++;
        }
        return false;
    }

    public boolean hasStrPath (char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] path, int strIndex) {
        //检查行号i和列号j是否下标越界
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        //获取一维数组中的当前下标
        int currentIndex = i * cols + j;
        //判断当前路径是否被走过 以及 当前值是否和对应的字符匹配  如果匹配对应布尔数组中的该位置设为true代表已经走过该路径
        if (!path[currentIndex] && matrix[currentIndex] == str[strIndex++]) {
            //设置路径已经走过
            path[currentIndex] = true;

            //如果字符下标=长度的时候就代表全部找到了 返回true 否则继续下个节点的判断
            if (strIndex >= str.length) {
                return true;
            } else {
                //如果上下左右四个地方有任何一个地方找到后续字符的就把当前路径设置为true 并返回  否则撤回走过的路径 返回false
                if (hasStrPath(matrix, rows, cols, str, i - 1, j, path, strIndex)
                        || hasStrPath(matrix, rows, cols, str, i, j + 1, path, strIndex)
                        || hasStrPath(matrix, rows, cols, str, i + 1, j, path, strIndex)
                        || hasStrPath(matrix, rows, cols, str, i, j - 1, path, strIndex)) {
                    return true;
                } else {
                    path[currentIndex] = false;
                    return false;
                }
            }
        }
        return false;
    }
}
