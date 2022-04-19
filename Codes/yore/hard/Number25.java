package com.yore.hard;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2021/9/10 16:11
 * @description
 */
public class Number25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        ListNode firstNode = reverse(head, end);
        head.next = reverseKGroup(end, k);
        return firstNode;
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode pre = null;
        ListNode nxt;
        while (begin != end) {
            nxt = begin.next;
            begin.next = pre;
            pre = begin;
            begin = nxt;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Number25 number25 = new Number25();
        number25.reverseKGroup(l1, 2);
    }
}
