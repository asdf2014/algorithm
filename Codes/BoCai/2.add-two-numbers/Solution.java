/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp=0,value=0;
        ListNode result=null, current=null;
        while(l1 != null || l2 != null){
            value = tmp;
            if(l1 != null){
                value += l1.val;
                l1=l1.next;
            } 
            if(l2 != null){
                value += l2.val;
                l2=l2.next;
            }
            if(value >= 10){
                tmp = 1;
                value -= 10;
            }else{
                tmp=0;
            }
            if(result == null){
                current = result = new ListNode(value);
            }else{
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        if(tmp > 0){
            current.next = new ListNode(tmp);
        }
        return result;
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}