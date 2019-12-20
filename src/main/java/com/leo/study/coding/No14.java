//package com.leo.study.coding;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//
///**
// * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
// * <p>
// * 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，
// * 若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
// * 请返回一个int[][](C++为vector&ltvector&ltint>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。
// * 保证数据合法。
// *
// * @author chao.li@quvideo.com
// * @date 2019/12/13 13:55
// */
//public class No14 {
//    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
//        // write code here
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        if (ope == null || ope.length < 1) {
//            return result;
//        }
//        int opCount = ope.length / 2;
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < opCount; i++) {
//            if (ope[i][0] == 1) {
//                list.addFirst(ope[i][1]);
//            } else {
//                list.removeFirst();
//            }
//        }
//        // 将LinkedList转换为ArrayList<ArrayList<Integer>>
//        Integer num;
//        ArrayList<Integer> arr=new ArrayList<>();
//        while ((num = list.pollFirst()) != null) {
//
//        }
//    }
//
//
//}
