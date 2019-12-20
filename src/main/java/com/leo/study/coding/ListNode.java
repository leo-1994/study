package com.leo.study.coding;

/**
 * @author chao.li@quvideo.com
 * @date 2019/10/2 18:05
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode create(int... nums) {
        ListNode head = null;
        ListNode pre = null;
        for (int n : nums) {
            ListNode cur = new ListNode(n);
            if (pre == null) {
                head = cur;
            } else {
                pre.next = cur;
            }
            pre = cur;
        }
        return head;
    }

    public static void printLinked(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + ">");
            cur = cur.next;
        }
    }
}
