package com.leo.study.juc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/26 18:14
 */
public class MyThreadFactory implements ThreadFactory {
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
