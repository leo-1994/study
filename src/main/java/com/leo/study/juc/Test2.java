package com.leo.study.juc;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：写一个固定容量同步容器，用于put和get方法，以及getCount方法。
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/24 13:56
 */
public class Test2 {
    public static class MyContainer<T> {
        private LinkedList<T> list = new LinkedList<>();
        private static final int MAX = 10;
        private int count = 0;


        public synchronized void put(T t) {
            while (count == MAX) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(t);
            count++;
            this.notifyAll();
        }

        public synchronized T get() {
            while (count == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            T t = list.pollFirst();
            this.notifyAll();
            return t;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    public static class MyContainer2<T> {
        private LinkedList<T> list = new LinkedList<>();
        private static final int MAX = 10;
        private int count = 0;
        private Lock lock = new ReentrantLock();
        private Condition producer = lock.newCondition();
        private Condition consumer = lock.newCondition();

        public void put(T t) {
            try {
                lock.lock();
                while (count == MAX) {
                    producer.await();
                }
                list.addLast(t);
                count++;
                consumer.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public T get() {
            try {
                lock.lock();
                while (count == 0) {
                    consumer.await();
                }
                T t = list.pollFirst();
                count--;
                producer.signal();
                return t;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            try {
                lock.lock();
                return count;
            } finally {
                lock.unlock();
            }
        }
    }




}
