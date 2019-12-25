package com.leo.study.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/25 14:07
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(CompletableFutureTest::priceOfTM);
        futureTM.thenAccept(r -> {
            System.out.println("tm price:" + r);
        }).get();
    }

    private static Double priceOfTM() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100.0;
    }

    private static Double priceOfTB() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 80.0;
    }

    private static Double priceOfJD() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 90.0;
    }
}
