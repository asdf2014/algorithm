package com.yore.easy;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/7/23 10:09
 * @description
 */
public class Interview0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }
}
