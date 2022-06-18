package com.yore.easy;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/5/14 8:49
 * @description
 */
public class Number83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while(right !=null && right.next!=null){
            if(right.val != right.next.val){
                left = left.next;
                left.val = right.next.val;
            }
            right = right.next;
        }
        left.next = null;
        return head;
    }
}
