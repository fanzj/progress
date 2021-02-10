package com.jary.progress.leetcodecn.linkedlist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 快慢指针
 */
public class Q876_链表的中间节点 {

    public ListNode middleNode(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
