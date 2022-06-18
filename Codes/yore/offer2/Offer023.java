package com.yore.offer2;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/1/21 16:45
 * @description
 */
public class Offer023 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a == null) {
                a = headB;
            }
            if (b == null) {
                b = headA;
            }
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
