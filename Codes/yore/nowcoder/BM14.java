package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/5/6 9:43
 * @description
 */
public class BM14 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode p1 = odd;
        ListNode even = head.next;
        ListNode p2 = even;
        while (p1.next != null && p1.next.next != null || p2.next != null && p2.next.next != null) {
            if (p1.next.next != null) {
                p1.next = p1.next.next;
                p1 = p1.next;
            }
            if (p2.next.next != null) {
                p2.next = p2.next.next;
                p2 = p2.next;
            } else {
                p2.next = null;
            }
        }
        p1.next = even;
        return odd;
    }
}
