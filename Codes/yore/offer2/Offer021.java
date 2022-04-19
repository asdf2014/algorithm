package com.yore.offer2;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2021/11/10 9:09
 * @description
 */
public class Offer021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero = new ListNode(-1,head);
        int k = 0;
        ListNode pre = zero;
        ListNode tail = zero;
        while(k++ <n){
            tail = tail.next;
        }

        while(tail.next !=null){
            pre = pre.next;
            tail = tail.next;
        }
        pre.next = pre.next.next;
        return zero.next;
    }
}
