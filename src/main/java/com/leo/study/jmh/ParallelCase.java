package com.leo.study.jmh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/25 23:09
 */
public class ParallelCase {
    static List<Integer> nums = new ArrayList<>();

    static {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            nums.add(1000000 + r.nextInt(10000));
        }
    }

    static void foreach() {
        nums.forEach(ParallelCase::isPrime);
    }

    static void paraller(){
        nums.parallelStream().forEach(ParallelCase::isPrime);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
