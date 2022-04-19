package com.yore.medium;

import com.yore.base.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/2/19 16:55
 * @description
 */
public class Number143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Deque<ListNode> deque = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            deque.offerLast(p);
            p = p.next;
        }
        int index = 0;
        ListNode q;
        p = head;
        while (index < deque.size()) {
            q = p.next;
            ListNode t = deque.pollLast();
            p.next = t;
            t.next = q;
            index++;
            if (index > deque.size()) {
                break;
            }
            p = q;

        }
        p.next = null;
    }
}
