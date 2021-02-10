package com.jary.progress.leetcodecn.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class 剑指Offer35_复杂链表的复制 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 借助hashmap
     * 时空复杂度 O(N)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {

        //原始节点 - 复制节点
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //串next关系
        cur = head;
        Node tmpCur = map.get(cur);
        while(cur != null) {
            tmpCur.next = map.get(cur.next);
            cur = cur.next;
            tmpCur = tmpCur.next;
        }

        //串random关系
        cur = head;
        tmpCur = map.get(cur);
        while(cur != null) {
            tmpCur.random = map.get(cur.random);

            cur = cur.next;
            tmpCur = tmpCur.next;
        }


        return map.get(head);
    }

    /**
     * 不借助辅助空间
     * 1、一开始先复制节点，接在原始节点后面，类似 A->A'->B->B'->C->C'
     * 2、串random关系
     * 3、分离出复制链表
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        //1.复制节点
        Node cur = head;
        while(cur != null) {
            Node cloneNode = new Node(cur.val);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }

        //2.串random关系
        cur = head;
        while(cur != null) {
            Node cloneNode = cur.next;
            if(cur.random != null) {
                cloneNode.random = cur.random.next;
            }
            cur = cloneNode.next;
        }

        //3.分离链表 偶数节点的 A->A'->B->B'->C->C'
        cur = head;
        Node cloneHead = null;
        Node cloneNode = null;
        if(cur != null) {
            cloneHead = cur.next;
            cloneNode = cur.next;
            cur.next = cloneNode.next;
            cur = cur.next;
        }

        while(cur != null) {
            cloneNode.next = cur.next;
            cloneNode = cloneNode.next;
            cur.next = cloneNode.next;
            cur = cur.next;
        }

        return cloneHead;

    }
}
