package com.yore.offer;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/6/4 8:09
 * @description
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
