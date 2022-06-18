package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/5/6 10:11
 * @description
 */
public class BM15 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int val = head.val;
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = p;
                val = p.val;
            }
            p = p.next;
        }
        return head;
    }
}
