package com.yore.nowcoder;

import com.yore.base.ListNode;

/**
 * @author Yore
 * @date 2022/5/3 10:30
 * @description 倒数第k个节点
 */
public class BM8 {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        int idx = 0;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (idx < k) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            idx++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
