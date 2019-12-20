package com.leo.study.coding;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/13 14:33
 */
public class No15 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        // stack1专门存储push进来的数
        stack1.push(node);
    }

    public int pop() {
        // stack2存储待pop的数
        // 当stack2为empty时，从stack1加载数据
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
