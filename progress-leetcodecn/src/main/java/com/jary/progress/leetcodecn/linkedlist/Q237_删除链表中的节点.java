package com.jary.progress.leetcodecn.linkedlist;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/submissions/
 * 同【面试题_删除中间节点】
 */
public class Q237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
