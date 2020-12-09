package com.jary.progress.leetcodecn.linkedlist;

/**
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class 面试题_删除中间节点 {

    public static void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode pre = cur;
        while (cur.next != null) {
            cur.val = cur.next.val;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
    }

    /**
     * 网上解答1
     * @param node
     */
    public static void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
