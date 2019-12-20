package com.leo.study.coding;

/**
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 19:00
 */
public class No12 {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode l1 = a;
        ListNode l2 = b;
        int d = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null || d != 0) {
            int sum = getInt(l1) + getInt(l2) + d;
            if (sum >= 10) {
                d = 1;
                sum = sum - 10;
            } else {
                d = 0;
            }
            ListNode cur = new ListNode(sum);
            if (head == null) {
                head = cur;
            }
            if (tail != null) {
                tail.next = cur;
            }
            tail = cur;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    private int getInt(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }
}
