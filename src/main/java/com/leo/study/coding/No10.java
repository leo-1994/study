package com.leo.study.coding;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * <p>
 * 给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/12 17:37
 */
public class No10 {
    public boolean removeNode(ListNode pNode) {
        // write code here
        if (pNode.next == null) {
            pNode = null;
            return false;
        } else {
            ListNode next = pNode.next;
            pNode.val = next.val;
            pNode.next = next.next;
            next = null;
            return true;
        }
    }
}
