package com.leo.study.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/24 19:55
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();
    }
}
