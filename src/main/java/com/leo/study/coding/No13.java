package com.leo.study.coding;

import java.util.LinkedList;

/**
 * 请编写一个函数，检查链表是否为回文。
 * <p>
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 19:30
 */
public class No13 {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null) {
            return false;
        }
        if (pHead.next == null) {
            return true;
        }
        LinkedList<Integer> list = new LinkedList<>();
        ListNode cur = pHead;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Integer a;
        Integer b;
        while ((a = list.pollFirst()) != null && (b = list.pollLast()) != null) {
            if (!a.equals(b)) {
                return false;
            }
        }
        return true;
    }
}
