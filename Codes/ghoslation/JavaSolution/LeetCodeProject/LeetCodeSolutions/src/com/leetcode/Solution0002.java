package com.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryNum = (l1.val + l2.val) / 10;
        ListNode ret = new ListNode((l1.val + l2.val)%10);
        ListNode retTail = ret;
        for(int i = 1; i < 100; i++) {
            if(l1 != null) {
                 l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            int sum = 0;
            if(l1 != null || l2 != null) {
                sum = ((l1==null)?0:l1.val) + ((l2==null)?0:l2.val) + carryNum;
                retTail.next = new ListNode(sum%10);
                retTail = retTail.next;
                carryNum = sum / 10;
            } else {
                if(carryNum > 0) {
                    retTail.next = new ListNode(carryNum);
                    retTail = retTail.next;
                }
                break;
            }
        }
        return ret;
    }
}