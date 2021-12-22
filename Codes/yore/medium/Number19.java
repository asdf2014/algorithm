package com.yore.medium;

import com.yore.base.ListNode;

/**
 * @author jia bing wen
 * @date 2021/5/7 20:48
 * @description 删除列表的倒数第n个节点，返回头节点
 */
public class Number19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero = new ListNode(0,head);
        ListNode first = head;
        ListNode second = zero;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first !=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return zero.next;
    }
}
