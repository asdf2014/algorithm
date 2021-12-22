package com.yore.easy;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/5/15 9:55
 * @description
 */
public class Number206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp;
        ListNode node1 = head;
        ListNode node2;
        tmp = head.next;
        head.next = null;
        while (tmp != null) {
            node2 = tmp.next;
            tmp.next = node1;
            node1 = tmp;
            tmp = node2;
        }
        return node1;
    }
}
