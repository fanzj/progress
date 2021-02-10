package com.jary.progress.leetcodecn.linkedlist;

/**
 * https://leetcode-cn.com/problems/merge-in-between-linked-lists/
 */
public class Q1669_合并两个链表 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode cur = list1;
        for(int i=0;i<a-1;i++){
            cur = cur.next;
        }

        ListNode left = cur;

        for(int i=0;i < (b-a +2);i++) {
            cur = cur.next;
        }
        ListNode right = cur;

        ListNode p = list2;
        while(p.next != null) {
            p = p.next;
        }

        left.next = list2;
        p.next = right;
        return head;
    }
}
