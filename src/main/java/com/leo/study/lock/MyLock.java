package com.leo.study.lock;

import sun.misc.Unsafe;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/23 22:02
 */
public class MyLock implements Lock {
    @Override
    public void lock() {
        Unsafe unsafe = Unsafe.getUnsafe();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
