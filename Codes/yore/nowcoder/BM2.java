package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/4/28 8:48
 * @description 链表内指定区间反转
 */
public class BM2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode ppre = new ListNode(-1);
        ppre.next = head;
        ListNode pre = ppre;
        while (head != null && len < m) {
            pre = head;
            head = head.next;
            len++;
        }
        if (head != null) {
            ListNode p = head.next;
            while (p != null && len < n) {
                head.next = p.next;
                p.next = pre.next;
                pre.next = p;
                p = head.next;
                len++;
            }
        }
        return ppre.next;
    }
}
