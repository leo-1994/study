package com.leo.study.queue;

import com.leo.study.map.MyConcurrentHashMap;

/**
 * @author chao.li@quvideo.com
 * @date 2019-06-13 16:30
 */
public class MyConcurrentHashMapTest {
    public static void main(String[] args) {
        MyConcurrentHashMap<Integer, Integer> map = new MyConcurrentHashMap<>(8);
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }
    }
}
