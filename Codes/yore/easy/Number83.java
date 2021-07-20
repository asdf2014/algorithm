package com.yore.easy;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/5/14 8:49
 * @description
 */
public class Number83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head.next;
        int preValue = head.val;
        ListNode preNode = head;
        while (node != null) {
            if (node.val == preValue) {
                preNode.next = node.next;
            } else {
                preNode = preNode.next;
                preValue = preNode.val;
            }
            node = node.next;
        }
        return head;
    }
}
