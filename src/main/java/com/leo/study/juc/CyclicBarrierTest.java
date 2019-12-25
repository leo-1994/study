package com.leo.study.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 理解为一个栅栏，当栅栏前到达当人数达到预设值（parties）时，一起释放
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/24 10:20
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("人满了，发车");
        });
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 上车");
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " 出发了");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
