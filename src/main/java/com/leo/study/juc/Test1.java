package com.leo.study.juc;

import java.util.concurrent.Semaphore;

/**
 * 题目：使用两个线程，交替打印A1B2C3....Z26
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/24 13:46
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        s2.acquire();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print((char) ('A' + i));
                s2.release();

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                try {
                    s2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + 1);
                s1.release();
            }
        }).start();
    }
}
