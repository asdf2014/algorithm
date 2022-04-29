package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/4/28 9:34
 * @description K个一组反转链表
 */
public class BM3 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return head;
            }
            node = node.next;
        }
        ListNode res = reverse(head,node);
        head.next = reverseKGroup(node,k);
        return res;
    }

    /**
     * 反转区间[begin,end)中的链表元素
     *
     * @param begin
     * @param end
     * @return
     */
    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode pre = new ListNode(-1);
        pre.next = begin;
        ListNode p = begin.next;
        while (p != end) {
            begin.next = p.next;
            p.next = pre.next;
            pre.next = p;
            p = begin.next;
        }
        return pre.next;
    }
}
