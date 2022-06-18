package com.yore.easy;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2021/10/8 10:35
 * @description 快慢指针解决链表中点问题
 */
public class Number876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
