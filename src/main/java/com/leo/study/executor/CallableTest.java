package com.leo.study.executor;

import java.util.concurrent.*;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/25 13:41
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "ok";
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
