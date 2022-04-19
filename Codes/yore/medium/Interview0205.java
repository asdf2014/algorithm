package com.yore.medium;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/7/25 15:26
 * @description
 */
public class Interview0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        int c = 0;
        int value = 0;
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while (node1 != null && node2 != null) {
            value = node1.val + node2.val + c;
            if (value >= 10) {
                c = 1;
                value -= 10;
            } else {
                c = 0;
            }
            ListNode node = new ListNode(value);
            newList.next = node;
            newList = node;
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode tmp = node1 != null ? node1 : node2;
        while (tmp != null) {
            value = tmp.val + c;
            if (value >= 10) {
                c = 1;
                value -= 10;
            } else {
                c = 0;
            }
            ListNode node = new ListNode(value);
            newList.next = node;
            newList = node;
            tmp = tmp.next;
        }
        if (c > 0) {
            newList.next = new ListNode(c);
        }
        return head.next;
    }


}
