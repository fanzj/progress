package com.jary.progress.leetcodecn.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 方法一：翻转链表，然后顺序遍历
 * 方法二：顺序遍历，塞到list
 * 方法三：递归
 */
public class 剑指Offer06_从尾到头打印链表 {

    /**
     * 方法二：顺序遍历，塞到list
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        Collections.reverse(list);

        int[] arr = new int[list.size()];
        int i = 0;
        for(Integer a : list){
            arr[i++] = a;
        }
        return arr;
    }

    //方法三：递归 AC
    public int[] reversePrint2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reverseData(head, list);

        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    private void reverseData(ListNode head, List<Integer> list) {
        if(head == null) {
            return;
        }

        if(head.next == null) {
            list.add(head.val);
            return ;
        }

        reverseData(head.next, list);
        list.add(head.val);
    }

    //############################################
    /**
     * 迭代反转链表，然后遍历输出
     * AC
     * @param head
     * @return
     */
    public int[] reversePrint3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        int size = 0;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            size ++;
        }

        int[] result = new int[size];
        int i = 0;
        while(pre != null) {
            result[i++] = pre.val;
            pre = pre.next;
        }


       return result;
    }

}
