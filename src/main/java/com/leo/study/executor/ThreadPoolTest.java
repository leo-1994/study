package com.leo.study.executor;

import com.leo.study.juc.MyThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/25 14:36
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                new MyThreadFactory("ThreadPoolTest"),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolExecutor.execute(() -> {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.shutdown();
    }

}
