package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/5/7 10:02
 * @description
 */
public class BM16 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode p = d;
        ListNode q = head;
        int cur = q.val;
        while (q != null) {
            if (q.val != cur) {
                if (p.next.next != q) {
                    p.next = q;
                } else {
                    p = p.next;
                }
                cur = q.val;
            }
            q = q.next;
        }
        if (p.next.next != null) {
            p.next = null;
        }
        return d.next;
    }
}
