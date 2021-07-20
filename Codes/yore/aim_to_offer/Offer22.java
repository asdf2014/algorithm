package com.yore.offer;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/5/28 9:01
 * @description
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        ListNode p = head;
        while (node != null) {
            if (count >= k) {
                p = p.next;
            }
            node = node.next;
            count++;
        }
        return p;
    }
}
