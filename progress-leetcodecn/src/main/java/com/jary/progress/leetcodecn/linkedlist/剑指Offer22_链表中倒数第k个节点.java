package com.jary.progress.leetcodecn.linkedlist;


/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 此题同面试题_返回倒数第k节点
 */
public class 剑指Offer22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(i++ < k) {
            fast = fast.next;
        }

        while(fast != null) {
            fast =fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
