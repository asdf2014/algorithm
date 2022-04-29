package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/4/27 9:24
 * @description 翻转链表
 */
public class BM1 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head.next;
        while(p!=null){
            head.next = p.next;
            p.next = pre.next;
            pre.next =p;
            p = head.next;
        }
        return pre.next;
    }
}
