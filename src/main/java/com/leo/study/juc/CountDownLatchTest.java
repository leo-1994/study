package com.leo.study.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch理解为门闩。当门闩都被放下(countDown)后通行。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/24 09:58
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + " done");
//                countDownLatch.countDown();
//            }).start();
//        }
//        countDownLatch.await();
//        System.out.println("结束");

        List<Integer> list = new ArrayList<>();
        CountDownLatch cc1 = new CountDownLatch(1);
        CountDownLatch cc2 = new CountDownLatch(1);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("add " + i);
                list.add(i);
                if (list.size() == 5) {
                    cc1.countDown();
                    try {
                        cc2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t1 end");
        }).start();
        new Thread(() -> {
            try {
                cc1.await();
                System.out.println("t2 end");
                cc2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
