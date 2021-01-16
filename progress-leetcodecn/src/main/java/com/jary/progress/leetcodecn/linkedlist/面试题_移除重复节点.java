package com.jary.progress.leetcodecn.linkedlist;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class 面试题_移除重复节点 {

    /**
     * 借助hashmap判断节点是否出现过
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        ListNode node = new ListNode(-1);
        ListNode p = node;
        while (cur != null) {
            if (!map.containsKey(cur.val)) {
                map.put(cur.val, cur);
                node.next = cur;
                node = node.next;
            }
            cur = cur.next;

        }
        node.next = null;
        return p.next;
    }

    /**
     * 利用hashmap优化版
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes2(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(head.val, 1);//将头节点先放到map
        ListNode cur = head;
        ListNode p = head;

        while(cur.next != null) {

            if(!map.containsKey(cur.next.val)) {
                //map中不存在，则放入map
                map.put(cur.next.val, 1);
                cur = cur.next;
            } else {
                //map中存在，则移除当前节点

                cur.next = cur.next.next;
            }

        }
        return p;
    }

    /**
     * 进阶做法：两重循环，只能拿空间换时间
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes3(ListNode head) {
        ListNode p = head;

        while(p != null) {
            ListNode q = p;
            while(q.next != null) {
                if(q.next.val == p.val) {
                    q.next = q.next.next;
                }else {
                    q = q.next;
                }
            }
            p = p.next;
        }
        return head;
    }


}
