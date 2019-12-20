package com.leo.study.queue;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author chao.li@quvideo.com
 * @date 2019-05-23 15:17
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(5);
//        priorityQueue.add(7);
//        priorityQueue.add(9);
//        priorityQueue.add(6);

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            priorityQueue.add(random.nextInt(100));
        }
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.poll());
        }
    }
}
