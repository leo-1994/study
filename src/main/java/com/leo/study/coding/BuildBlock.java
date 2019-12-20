package com.leo.study.coding;

/**
 * 用两种积木，2X1型，1X1型，摆满n行m列，有多少种摆法。
 * 这是一个斐波那契数列问题
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 11:10
 */
public class BuildBlock {
    /**
     * 对于两种积木:2*1型和1*1型，搭n行m列有几种搭法。
     * 思路:先考虑搭一列的情况，再递归调用即可。
     * 对于搭一列的问题，就是走楼梯问题，一次可以走一步或者两步，总共有多少种走法。
     */
    public static int buildBlock(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        } else if (m == 1) {
            return coloum(n);
        } else {
            return coloum(n) * buildBlock(n, m - 1);
        }

    }

    public static int coloum(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return coloum(n - 1) + coloum(n - 2);
        }
    }


    public static void main(String[] args) {
        int n = 3, m = 4;
        System.out.print(buildBlock(n, m));
    }
}
