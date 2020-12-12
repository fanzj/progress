package com.jary.progress.leetcodecn.linkedlist;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class Q1290_二进制链表转整数 {

    /**
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int sum = 0;
        while(cur != null) {
            sum = sum * 2 + cur.val;
            cur = cur.next;
        }
        return sum;
    }


}
