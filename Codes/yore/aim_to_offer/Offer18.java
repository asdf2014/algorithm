package com.yore.offer;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/6/1 9:22
 * @description
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode node = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return node;
    }
}
