package com.leo.study.jmh;

import org.openjdk.jmh.annotations.*;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/25 23:03
 */
public class ParallelTest {

    @Benchmark
    @Warmup(iterations = 1, time = 3) // 预热，调用1次，等3秒
    @Fork(5) // 用5个线程
    @BenchmarkMode(Mode.Throughput) //测试模式，Throughput为吞吐量
    @Measurement(iterations = 1, time = 3) // 迭代
    public void testForEach() {
        ParallelCase.foreach();
    }

    @Benchmark
    @Warmup(iterations = 1, time = 3) // 预热，调用1次，等3秒
    @Fork(5) // 用5个线程
    @BenchmarkMode(Mode.Throughput) //测试模式，Throughput为吞吐量
    @Measurement(iterations = 1, time = 3) // 迭代
    public void testForParaller() {
        ParallelCase.paraller();
    }
}
