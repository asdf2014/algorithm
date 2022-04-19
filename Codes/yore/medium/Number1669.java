package com.yore.medium;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/7/25 14:42
 * @description
 */
public class Number1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode tmp = null;
        ListNode pre = null;
        ListNode head = list1;
        while (list1 != null && count < a) {
            pre = list1;
            list1 = list1.next;
            count++;
        }
        if (pre == null) {
            pre = list2;
            head = list2;
        } else {
            pre.next = list2;
        }
        while (list2 != null) {
            tmp = list2;
            list2 = list2.next;
        }
        while (list1 != null && count <= b) {
            list1 = list1.next;
            count++;
        }
        if (tmp != null) {
            tmp.next = list1;
        }
        return head;
    }
}
