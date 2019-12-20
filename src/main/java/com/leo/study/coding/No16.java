package com.leo.study.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * <p>
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/13 14:52
 */
public class No16 {

    /**
     * 思路：以冒泡排序的思路实现，从栈顶取出两个元素比较，需要排序则换位置入栈，
     * 若不需要排序则把第一个元素放入临时栈，再取出一个元素比较，以此类推，直到取到底，则排序完成
     *
     * @param numbers
     * @return
     */
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        if (numbers.length == 0) {
            return new ArrayList<>(0);
        }
        if (numbers.length == 1) {
            return new ArrayList<>(Collections.singletonList(numbers[0]));
        }
        int stackHead = numbers.length - 1;
        LinkedList<Integer> tempStack = new LinkedList<>();
        while (stackHead >= 0) {
            Integer temp = tempStack.peekFirst();
            // 将numbers理解为栈，则now为栈顶元素
            int now = numbers[stackHead];
            if (temp == null) {
                // 如果临时栈为空，则直接将栈顶元素放入临时栈
                tempStack.addFirst(now);
                stackHead--;
            } else if (now >= temp) {
                // 如果now>=temp,则取出now放入临时栈
                tempStack.addFirst(now);
                stackHead--;
            } else {
                // 如果now<temp,则取出临时栈元素放入原栈
                numbers[stackHead] = tempStack.pollFirst();
                numbers[++stackHead] = now;
            }
        }
        return new ArrayList<>(tempStack);
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = new No16().twoStacksSort(new int[]{1, 3, 2, 5, 4});
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
