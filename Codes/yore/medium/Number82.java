package com.yore.medium;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/5/14 9:16
 * @description
 */
public class Number82 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(4);
        ListNode h6 = new ListNode(5);
        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        System.out.println(deleteDuplicates(h));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode beginNode = head;
        ListNode endNode = head.next;
        ListNode tmp = head;
        int count = 1;
        while (endNode != null) {
            count = 1;
            while (endNode != null && endNode.val == beginNode.val) {
                count++;
                endNode = endNode.next;
            }
            if (count > 1) {
                if (head == beginNode) {
                    head = endNode;
                } else {
                    tmp.next = endNode;
                }
                beginNode = endNode;
                if (endNode == null) {
                    break;
                }
                endNode = endNode.next;
            } else {
                if (endNode == null) {
                    break;
                }
                tmp = beginNode;
                beginNode = endNode;
                endNode = endNode.next;
            }
        }
        return head;
    }
}
