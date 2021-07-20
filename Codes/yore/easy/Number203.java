package com.yore.easy;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/5/15 9:49
 * @description
 */
public class Number203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode listNode = pre;
        while (listNode.next != null) {
            if(listNode.next.val == val){
                listNode.next = listNode.next.next;
            }else{
                listNode = listNode.next;
            }
        }
        return pre.next;
    }
}
