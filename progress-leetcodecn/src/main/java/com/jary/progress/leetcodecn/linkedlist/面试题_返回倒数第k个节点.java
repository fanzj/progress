package com.jary.progress.leetcodecn.linkedlist;

/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class 面试题_返回倒数第k个节点 {

    /**
     * 方法一：遍历统计总节点数n，然后再次遍历n-k+1个
     * 方法二：维护两个指针，让第一个指针先走k步
     * 方法三：压栈，弹出k个
     * 方法四：递归
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        int step = 0;

        while(step < k){
            step ++;
            first = first.next;
        }
        while(first != null) {
            first= first.next;
            second = second.next;
        }
        return second.val;
    }

    //递归方法（网上方法）#####################################
    private int size = 0;

    public int kthToLast2(ListNode head, int k) {
        if(head == null) {
            return 0;
        }

        int val = kthToLast2(head.next, k);
        size ++;//从最底层先开始加

        if(size < k) {
            return 0;
        }else if(size == k){
            return head.val;
        }else {
            return val;
        }
    }
}
