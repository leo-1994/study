package com.leo.study.queue;

/**
 * @author chao.li@quvideo.com
 * @date 2019-05-24 10:59
 */
public class MyDequeTest {
    public static void main(String[] args) {
        MyDeque<Integer> myDeque = new MyDeque<>(5);
        myDeque.addFirst(4);
        myDeque.addFirst(5);
        myDeque.addLast(6);
        for (Integer data : myDeque) {
            System.out.println(data);
        }
    }
}
