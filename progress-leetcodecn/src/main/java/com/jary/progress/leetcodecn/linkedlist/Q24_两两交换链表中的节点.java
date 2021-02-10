package com.jary.progress.leetcodecn.linkedlist;

public class Q24_两两交换链表中的节点 {

    /**
     * 递归
     * 1->2->3->4
     * 2->1->4->3
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

       ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 迭代
     * 设置哑节点
     * -1->1->2->3->4
     * 2->1->4->3
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
       ListNode dummy = new ListNode(-1);
       dummy.next = head;

       ListNode temp = dummy;
       while(temp.next != null && temp.next.next != null) {
           ListNode p1 = temp.next;
           ListNode p2 = temp.next.next;

           temp.next = p2;
           p1.next = p2.next;
           p2.next = p1;


           temp = p1;
       }
       return dummy.next;
    }
}
