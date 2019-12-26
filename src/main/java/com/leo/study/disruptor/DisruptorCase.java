package com.leo.study.disruptor;

import com.leo.study.juc.MyThreadFactory;
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/26 18:03
 */
public class DisruptorCase {
    public static void main(String[] args) {
        Disruptor<StringEvent> disruptor = new Disruptor<>(StringEvent::new, 1024, new MyThreadFactory("DisruptorCase"));
        RingBuffer<StringEvent> ringBuffer = disruptor.getRingBuffer();

        disruptor.handleEventsWith((event, sequence, endOfBatch) -> System.out.println(event.getMsg()));
        disruptor.start();
        for (int i = 0; i < 10; i++) {
            ringBuffer.publishEvent((event, sequence, arg0) -> {
                event.setMsg(arg0);
            }, "m" + i);
        }

    }
}
