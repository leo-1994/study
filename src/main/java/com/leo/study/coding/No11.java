package com.leo.study.coding;

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * <p>
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 17:52
 */
public class No11 {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 生成一个虚节点作为头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode cur = pHead;
        ListNode pre = dummyHead;
        while (cur != null) {
            if (cur.val < x) {
                if (lessHead == null) {
                    lessHead = cur;
                }
                if (lessTail != null) {
                    lessTail.next = cur;
                }
                lessTail = cur;
                // 将cur节点移出
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = pre.next;
        }
        if (lessTail == null) {
            return dummyHead.next;
        }
        lessTail.next = dummyHead.next;
        return lessHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create(3, 1, 2, 4, 5, 3);
        head = new No11().partition(head, 3);
        ListNode.printLinked(head);
    }
}
