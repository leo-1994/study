package com.leo.study;

import java.util.Random;

/**
 * 赌徒和美女问题
 *
 * @author chao.li@quvideo.com
 * @date 2019-06-03 16:56
 */
public class GamblerBeautyQuestion {

    public static void main(String[] args) {
        Random random = new Random();
        // 总体赢钱的计数
        int winCount = 0;
        // 总体输钱的计数
        int loseCount = 0;
        for (int k = 0; k < 100; k++) {
            int e = 0;
            for (int i = 0; i < 1000; i++) {
                boolean x = random.nextInt(30) < 15;
                // 设y为true当概率为11/30
                boolean y = random.nextInt(30) < 11;
                // 累加获得总收益
                e += reward(random.nextInt(30) < 15, random.nextInt(30) < 11);
            }
            if (e >= 0) {
                winCount++;
            } else {
                loseCount++;
            }
            System.out.println(e);
        }
        System.out.println("winCount:" + winCount + ",loseCount:" + loseCount);
    }

    /**
     * 获得一次赌博收益
     *
     * @param x
     * @param y
     * @return
     */
    private static int reward(boolean x, boolean y) {
        if (x && y) {
            // 都是正时赢3
            return 3;
        }
        if (!x && !y) {
            // 都是反时赢1
            return 1;
        }
        // 否则输2
        return -2;
    }
}
