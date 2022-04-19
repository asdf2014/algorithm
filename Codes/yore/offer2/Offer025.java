package com.yore.offer2;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/2/25 10:52
 * @description
 */
public class Offer025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverseNode(l1);
        ListNode node2 = reverseNode(l2);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int val1 = node1 != null ? node1.val : 0;
            int val2 = node2 != null ? node2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            p.next = node;
            p = node;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if (carry != 0) {
            ListNode node = new ListNode(1);
            p.next = node;
            p = node;
        }
        return reverseNode(dummy.next);
    }

    public ListNode reverseNode(ListNode node) {
        ListNode head = null;
        while (node != null) {
            ListNode t = node.next;
            node.next = head;
            head = node;
            node = t;
        }
        return head;
    }
}
