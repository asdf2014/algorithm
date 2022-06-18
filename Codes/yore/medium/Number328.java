package com.yore.medium;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/7/30 8:45
 * @description
 */
public class Number328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        int count = 1;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenFirst = evenNode;
        if (evenNode == null) {
            return head;
        }
        ListNode it = evenNode.next;
        while (it != null) {
            if (count % 2 == 0) {
                evenNode.next = it;
                evenNode = it;
                it = it.next;
                evenNode.next = null;
            } else {
                oddNode.next = it;
                oddNode = it;
                it = it.next;
                oddNode.next = null;
            }
            count++;
        }
        oddNode.next = evenFirst;
        evenNode.next = null;
        return head;
    }
}
