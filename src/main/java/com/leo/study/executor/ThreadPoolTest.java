package com.leo.study.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    public static class MyThreadFactory implements ThreadFactory {

        private final String namePrefix;
        private final AtomicInteger nextId = new AtomicInteger(1);

        public MyThreadFactory(String group) {
            namePrefix = "From MyThreadFactory's " + group + " -Worker-";
        }

        @Override
        public Thread newThread(Runnable r) {
            String name = namePrefix + nextId.getAndIncrement();
            Thread thread = new Thread(null, r, name, 0);
            thread.setDaemon(false);
            return thread;
        }
    }
}
