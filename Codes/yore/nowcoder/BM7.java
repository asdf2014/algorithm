package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/4/30 9:16
 * @description
 */
public class BM7 {
    public static void main(String[] args) {
        BM7 bm7 = new BM7();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        l5.next = l3;
        System.out.println(bm7.EntryNodeOfLoop(l1));
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = pHead;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
