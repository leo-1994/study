package com.leo.study.coding;

/**
 * 链表反转
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/11 17:34
 */
public class LinkedReverse {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node create(int... num) {
        Node head = null;
        Node pre = null;
        for (int n : num) {
            Node cur = new Node(n);
            if (pre == null) {
                head = cur;
            } else {
                pre.next = cur;
            }
            pre = cur;
        }
        return head;
    }

    public static void printLinked(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + ">");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LinkedReverse linkedReverse = new LinkedReverse();
        Node l1 = linkedReverse.create(1, 2, 3, 4, 5);
        printLinked(l1);
        System.out.println();
        Node l2 = linkedReverse.reverse(l1, 3);
        printLinked(l2);
    }

    /**
     * 逆序反转链表
     *
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 以K个元素为一组从头开始逆序，若最后一组不足K个则最后一组不逆序
     *
     * @param head
     * @param k
     * @return
     */
    public Node reverse(Node head, int k) {
        return reverseNode(head, k, 1);
    }

    public Node reverseNode(Node head, int k, int h) {
        if (head == null || head.next == null) {
            if(h==k){
                return head;
            }
        }
        Node newHead = reverseNode(head.next, k, h + 1);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
