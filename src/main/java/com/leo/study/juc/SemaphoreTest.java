package com.leo.study.juc;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 可以理解为信号灯。
 * 通过Semaphore可以实现限流等场景功能。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/24 10:24
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 通过");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
