package com.leo.study;

/**
 * @author chao.li@quvideo.com
 * @date 2019/11/6 14:23
 */
public class Test {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("new thread name:" + Thread.currentThread().getName());
        });
        t.start();
        System.out.println("main thread name:" + Thread.currentThread().getName());

    }
}
