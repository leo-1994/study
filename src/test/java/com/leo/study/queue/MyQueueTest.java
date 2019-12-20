package com.leo.study.queue;

import java.util.Iterator;

/**
 * @author chao.li@quvideo.com
 * @date 2019-05-23 13:55
 */
public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>(3);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
//        myQueue.offer(4);
//        myQueue.remove();
//        System.out.println(myQueue.remove());
//        for (Integer integer : myQueue) {
//            System.out.println(integer);
//        }
        Iterator iterator = myQueue.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
        System.out.println(myQueue.size());
    }
}
