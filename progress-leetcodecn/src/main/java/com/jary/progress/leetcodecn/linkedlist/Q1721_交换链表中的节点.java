package com.jary.progress.leetcodecn.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 */
public class Q1721_交换链表中的节点 {

    /**
     * 1->2->3->4->5
     * k = 2
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int cnt = 0;
        ListNode cur = head;
        //第一次遍历，统计节点数
        while(cur != null) {
            cnt ++;
            cur = cur.next;
        }

        if(k > cnt/2) {
            k = cnt - k + 1;
        }

        //设置哑节点
        ListNode temp = new ListNode(-1);
        temp.next = head;
        cur = temp;

        //第二次遍历，找出要交换的节点
        int pos = 0;
        while(pos < k) {
            cur = cur.next;
            pos ++;
        }

        int left = cur.val;
        while(pos < (cnt - k + 1)) {
            cur = cur.next;
            pos ++;
        }

        int right = cur.val;

        //第三次遍历，设置值
        cur = temp;
        pos = 0;
        while(pos < k) {
            cur = cur.next;
            pos ++;
        }
        cur.val = right;

        while(pos < (cnt - k + 1)) {
            cur = cur.next;
            pos ++;
        }

        cur.val = left;

        return head;

    }

    /**
     * 借助容器
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes2(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        if(list.size() <= 1){
            return head;
        }

        ListNode left = list.get(k-1);
        ListNode right = list.get(list.size()-k);

        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        return head;
    }

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes3(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;

        int pos = 1;
        while(cur.next != null) {
            if(pos < k) {
                slow = slow.next;
            }else {
                fast = fast.next;

            }
            pos ++;
            cur = cur.next;
        }

        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;
        return head;
    }

}
