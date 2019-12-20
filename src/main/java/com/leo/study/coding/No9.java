package com.leo.study.coding;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 17:15
 */
public class No9 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        if (k > list.size()) {
            return null;
        }
        return list.get(list.size() - k);
    }


}
