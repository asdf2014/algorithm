package com.yore.offer2;

import com.yore.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/3/12 9:18
 * @description
 */
public class Offer078 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res;
        int len = lists.length;
        if (len <= 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (queue.size() > 0) {
            ListNode n = queue.poll();
            cur.next = n;
            cur = n;
            if (n.next != null) {
                queue.offer(n.next);
            }
        }
        return dummy.next;
    }
}
