package com.yore.nowcoder;

import com.yore.base.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/6 9:12
 * @description 单链表排序
 */
public class BM12 {
    /**
     * 辅助数组
     *
     * @param head
     * @return
     */
    public ListNode sortInList1(ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode pre = null;
        for (Integer val : list) {
            ListNode node = new ListNode(val);
            if (pre == null) {
                dummy.next = node;
            } else {
                pre.next = node;
            }
            pre = node;
        }
        return dummy.next;
    }

    //归并排序
    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortInList(head);
        ListNode right = sortInList(tmp);
        ListNode h = new ListNode(-1);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
