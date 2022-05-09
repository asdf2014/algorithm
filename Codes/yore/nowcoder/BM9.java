package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/5/3 11:03
 * @description
 */
public class BM9 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = head;
        int index = 0;
        while (index < n) {
            fast = fast.next;
            index++;
        }
        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
        }
        if (pre.next == head) {
            pre.next = pre.next.next;
            return pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
