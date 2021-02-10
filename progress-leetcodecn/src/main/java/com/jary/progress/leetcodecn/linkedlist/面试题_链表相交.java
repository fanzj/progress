package com.jary.progress.leetcodecn.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 * 解答：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/solution/ji-he-shuang-zhi-zhen-deng-3chong-jie-jue-fang-s-3/
 */
public class 面试题_链表相交 {

    /**
     * 利用栈，从尾节点开始比较
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<>();

        ListNode cur = headA;
        while (cur != null) {
            stackA.push(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            stackB.push(cur);
            cur = cur.next;
        }

        ListNode pre = null;
        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            if(stackA.peek() != stackB.peek()) {
                return pre;
            }

            pre = stackA.pop();
            stackB.pop();
        }

        return pre;
    }

    /**
     * 根据路径
     * 设链表A的长度为a，链表B的长度为b，A到相交结点的距离为c,B到相交节点的距离为d，显然可以得到两者相交链表的长度：a - c = b - d， 变换一下式子得到:a + d = b + c
     * 我们用一个指针从链表A出发，到末尾后就从B出发，用另一个指针从B出发，到末尾后从A出发，由于上面的公式，当前一个指针走了a+d步数时，后一个指针走了b+c,两步数相等，即走到了相交节点。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
      ListNode p1 = headA;
      ListNode p2 = headB;
      while(p1!=p2) {
          p1 = p1 != null ? p1.next : headB;
          p2 = p2 != null ? p2.next : headA;
      }

      return p1;
    }


}
