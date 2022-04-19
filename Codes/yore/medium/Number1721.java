package com.yore.medium;

import com.yore.base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/7/30 9:25
 * @description
 */
public class Number1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = null, node2 = null;
        Stack<ListNode> st = new Stack<>();
        ListNode h = head;
        int count = 1;
        while (head != null) {
            st.push(head);
            if (count == k) {
                node1 = head;
            }
            head = head.next;
            count++;
        }
        count = 1;
        while (!st.isEmpty()) {
            node2 = st.pop();
            if (count++ == k) {
                break;
            }
        }
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
        return h;
    }


    public ListNode swapNodes1(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode h = head;
        while (h != null) {
            list.add(h);
            h = h.next;
        }
        int len = list.size();
        int val = list.get(k - 1).val;
        list.get(k - 1).val = list.get(len - k).val;
        list.get(len - k).val = val;
        return head;
    }

    public ListNode swapNodes2(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        int val = slow.val;
        slow.val = pre.val;
        pre.val = val;
        return head;
    }
}
