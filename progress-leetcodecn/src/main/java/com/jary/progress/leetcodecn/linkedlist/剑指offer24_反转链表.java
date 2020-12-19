package com.jary.progress.leetcodecn.linkedlist;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class 剑指offer24_反转链表 {

    /**
     * 方法一：迭代（双指针）
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while(cur  != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 方法二：递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return recur(head, null);
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if(cur == null) {
            return pre;
        }
        ListNode tmp = recur(cur.next, cur);//递归后继节点
        cur.next = pre;
        return tmp;
    }

    /**
     * 递归的另外一种写法
     * 假设链表 1->2->3->4->5
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseList3(head.next);//尾节点

        //假设head=4
        head.next.next = head;//5->4
        head.next = null;//4->null
        return cur;
    }
}
