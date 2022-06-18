package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/5/5 14:31
 * @description
 */
public class BM11 {

    public static void main(String[] args) {
        BM11 bm11 = new BM11();
        ListNode l3 = new ListNode(7);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(9, l2);

        ListNode h2 = new ListNode(3);
        ListNode h1 = new ListNode(6, h2);

        System.out.println(bm11.addInList(l1, h1));
    }

    ListNode dummy = new ListNode(-1);
    ListNode pre = null;

    public ListNode addInList(ListNode head1, ListNode head2) {
        ListNode p1 = reverse(head1);
        ListNode p2 = reverse(head2);
        int cri = 0;

        while (p1 != null || p2 != null) {
            int val = cri;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            cri = val >= 10 ? 1 : 0;
            buildList(val % 10);
        }
        if (cri > 0) {
            buildList(1);
        }
        return dummy.next;
    }

    public void buildList(int val) {
        ListNode node = new ListNode(val);
        node.next = pre;
        pre = node;
        dummy.next = node;
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
