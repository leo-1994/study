package com.leo.study.coding;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/12 20:41
 */
public class Test {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head=new Test().reverseList(head);
        ListNode cur=head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }

    public ListNode add(ListNode l1,ListNode l2){
        ListNode n1=reverseList(l1);
        ListNode n2=reverseList(l2);
        ListNode head=null;
        ListNode tail=null;
        int d=0;
        while(n1!=null||n2!=null||d!=0){
            int sum=getInt(n1)+getInt(n2)+d;
            if(sum>=10){
                d=1;
                sum=sum-10;
            }else{
                d=0;
            }
            ListNode cur=new ListNode(sum);
            if(head==null){
                head=cur;
            }
            if(tail!=null){
                tail.next=cur;
            }
            tail=cur;
            if(n1!=null){
                n1=n1.next;
            }
            if(n2!=null){
                n2=n2.next;
            }
        }
        return reverseList(head);
    }

    //
    private int getInt(ListNode node){
        if(node==null){
            return 0;
        }
        return node.val;
    }

    // 通过递归实现反转链表
    private ListNode reverseList(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        ListNode newHead=reverseList(node.next);
        node.next.next=node;
        node.next=null;
        return node;
    }
}
