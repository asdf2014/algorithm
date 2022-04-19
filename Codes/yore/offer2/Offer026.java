package com.yore.offer2;

import com.yore.base.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/2/19 14:55
 * @description
 */
public class Offer026 {
    public static void main(String[] args) {
//        Deque<Integer> queue = new LinkedList<>();
//        queue.offerLast(1);
//        queue.offerLast(2);
//        queue.offerLast(3);
//        System.out.println(queue.peekFirst());
//        System.out.println(queue.peek());
//        System.out.println(queue.pollFirst());
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reorderList(node1);
    }

    public static void reorderList(ListNode head) {
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
