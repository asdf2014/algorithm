package com.yore.medium;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/7/30 9:00
 * @description
 */
public class Number92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode node = head;
        ListNode stepOneEnd = pre;
        ListNode begin = null;
        ListNode end = null;
        while (node != null) {
            if (count < left) {
                stepOneEnd = node;
                node = node.next;
            } else if (count <= right) {
                if (begin == null) {
                    begin = node;
                    end = node;
                    node = node.next;
                    end.next = null;
                } else {
                    ListNode tmp = begin;
                    begin = node;
                    node = node.next;
                    begin.next = tmp;
                }
            } else {
                if (end != null) {
                    end.next = node;
                }
                break;
            }
            count++;
        }
        stepOneEnd.next = begin;
        return pre.next;
    }
}
