package com.leo.study.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chao.li@quvideo.com
 * @date 2019-06-18 14:54
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            try {
                System.out.println("take1 start");
                System.out.println("take1 value:" + queue.take());
                System.out.println("take1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        executorService.submit(() -> {
//            try {
//                System.out.println("take2 start");
//                System.out.println("take2 value:" + queue.take());
//                System.out.println("take2 end");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.submit(() -> {
//            try {
//                System.out.println("put start");
//                Thread.sleep(3000);
//                queue.put(33);
//                System.out.println("put end");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        System.out.println(queue.size());
        executorService.shutdown();
    }
}
