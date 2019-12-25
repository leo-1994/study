package com.leo.study.juc;

import java.util.concurrent.Exchanger;

/**
 * 用于交换两个线程的变量
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/24 11:18
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                name = exchanger.exchange(name);
                System.out.println(String.format("%s 获得 %s", Thread.currentThread().getName(), name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                name = exchanger.exchange(name);
                System.out.println(String.format("%s 获得 %s", Thread.currentThread().getName(), name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
