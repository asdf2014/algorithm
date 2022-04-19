package com.yore.medium;

import com.yore.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/7/27 9:14
 * @description
 */
public class Number142 {
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        while (node1 != null && node2 != null) {
            node1 = node1.next;
            if (node2.next != null) {
                node2 = node2.next.next;
            }else{
                return null;
            }
            //说明有环
            if (node1 == node2) {
                ListNode pre = head;
                while(pre!=node1){
                    pre = pre.next;
                    node1 = node1.next;
                }
                return pre;
            }
        }
        return null;
    }
}
