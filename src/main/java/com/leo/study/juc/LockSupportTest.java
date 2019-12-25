package com.leo.study.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/24 11:22
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            LockSupport.park();
            System.out.println("t1 end");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(t1);
            System.out.println("t2 end");
        });
        t1.start();
        t2.start();
    }
}
