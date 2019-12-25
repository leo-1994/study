package com.leo.study.executor;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/25 21:39
 */
public class WorkStealingPoolTest {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        run2();
        System.out.println("耗时:" + (System.currentTimeMillis() - start));
//        System.in.read();
    }

    private static int[] arr = new int[1000000];
    private static Random random = new Random();

    static {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
    }

    public static void run1() {
        long sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }

    public static void run2() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> joinTask = forkJoinPool.submit(new AddTask(0, arr.length));
        try {

            System.out.println(joinTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static class AddAction extends RecursiveAction {

        private static final long serialVersionUID = -8028122351006270343L;
        int start, end;

        private static final int MAX_NUM = 5000;

        public AddAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                System.out.println("form:" + start + " to:" + end + " = " + sum);
            } else {
                int middle = (end + start) / 2;
                AddAction subTask1 = new AddAction(start, middle);
                AddAction subTask2 = new AddAction(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }

    public static class AddTask extends RecursiveTask<Long> {

        private static final long serialVersionUID = -8028122351006270343L;
        int start, end;

        private static final int MAX_NUM = 50000;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {
                int middle = (end + start) / 2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
        }
    }
}
