package com.yore.offer2;

import com.yore.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/3/12 9:13
 * @description
 */
public class Offer077 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode node = head;
        while (node != null) {
            queue.add(node);
            node = node.next;
        }
        ListNode result = queue.poll();
        ListNode t = result;
        while (queue.size() > 0) {
            t.next = queue.peek();
            t = queue.poll();
        }
        t.next = null;
        return result;
    }
}
