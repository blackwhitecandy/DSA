package com.toffee.dsa.referToOffer;

/**
 * @Author: glz
 * @Description: 每年六一儿童节, 牛客都会准备一些小礼物去看望孤儿院的小朋友, 今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 * @Date: Create in 2019/12/26
 */
public class Topic46LastRemaining {
    /**
     * 获取最后的小朋友编号
     * @param m
     * @param n 小朋友的数量
     * @return
     */
    public int lastRemaining( int n,int m) {
        //没有孩子 直接返回-1
        if (n < 1) {
            return -1;
        }
        if (m == 0 || m == 1) {
            return n;
        }
        //定义孩子数组  值为0代表还没获取到礼物 值为1 代表已经获取到礼物
        int[] children = new int[n];
        //当前孩子下标
        int currentChildNo = -1;
        //没有获取到礼物的孩子的数目
        int noGiftChildNum = n;
        for (int i = 0; i < n - 1; i++) {
            //对剩余孩子数取余  获取真实的需要计数的次数
            int j = (m % noGiftChildNum == 0 ? m : m % noGiftChildNum);
            while (j > 0) {
                currentChildNo++;
                //如果当前孩子值为0 未获取到礼物 j-- 计数减一
                if (children[currentChildNo % n] == 0) {
                    j--;
                }
            }
            //设置当前孩子值为1
            children[currentChildNo % n] = 1;
            //没有礼物的孩子数 减一
            noGiftChildNum--;
            //当前孩子下标+1  从下个小朋友开始计数
            currentChildNo = currentChildNo % n;
        }
        //遍历获取最后一个没有礼物的孩子下标
        for (int i = 0; i < n; i++) {
            if (children[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 获取最后的小朋友编号
     * @param m
     * @param n 小朋友的数量
     * @return
     */
    public int lastRemaining1( int n,int m) {
        //没有孩子 直接返回-1
        if (n < 1) {
            return -1;
        }
        //如果m等于1  那肯定是第n个孩子 最后获得礼物
//        if (m == 1) {
//            return n;
//        }

        //定义孩子数组  让前一个没礼物的孩子保存下一个没礼物孩子的下标
        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            children[i] = (i + 1) % n;
        }

        //前孩子下标
        int currentChildPreNo = n - 1;
        //当前孩子下标
        int currentChildNo = 0;
        int noGiftChildNo = n;
        //遍历 当没有礼物的孩子 只有1个的时候 结束遍历
        while (noGiftChildNo > 1) {
            //对剩余孩子数取余  获取真实的需要计数的次数
            int j = (m % noGiftChildNo == 0 ? m : m % noGiftChildNo);
            //如果j = 1 相当于就是当前元素 要或得礼物 所以pre不需要变
            if (j > 1) {
                //遍历获取要获得礼物孩子的前一个没获得礼物的孩子 pre
                while (--j > 1) {
                    //获取下个（孩子）元素下标
                    currentChildNo = children[currentChildNo];
                }
                //更新preNo
                currentChildPreNo = currentChildNo % n;
            }

            //设置前元素的值指向下下个元素 也就是当前元素的下个元素   相当于把当前元素（获得礼物）移除掉了

            currentChildNo = children[currentChildPreNo];
            children[currentChildPreNo] = children[currentChildNo];
            children[currentChildNo] = -1;

            //更新当前计数要开始的下标
            currentChildNo = children[currentChildPreNo];

            //没有礼物的孩子数 减一
            noGiftChildNo--;
        }

        return currentChildNo;
    }
}
