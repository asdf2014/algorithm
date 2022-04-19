package com.yore.hard;

import com.yore.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/3/31 8:21
 * @description
 */
public class Number23 {



    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode it = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            queue.add(lists[i]);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
                it = head;
            }
            if (node.next != null) {
                queue.offer(node.next);
            }
            it.next = node;
            it = node;
        }
        return head;
    }
}
