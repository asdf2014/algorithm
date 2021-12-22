package com.yore.offer;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/6/4 8:09
 * @description
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
