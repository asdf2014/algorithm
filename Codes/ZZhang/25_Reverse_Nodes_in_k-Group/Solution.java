//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
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

/**
 * Reverse a link list between begin and end exclusively
 * an example:
 * a linked list:
 * 0->1->2->3->4->5->6
 * |           |
 * begin       end
 * after call begin = reverse(begin, end)
 *
 * 0->3->2->1->4->5->6
 *          |  |
 *      begin end
 * @return the reversed list's 'begin' node, which is the precedence of node end
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next ==null || k == 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        int pos = 1;

        while (head != null) {
            if (pos % k == 0){
                start = reverse(start, head.next);
                head = start.next;
            } else {
                head = head.next;
            }
            pos++;
        }


        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode first = cur;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = pre;
        first.next = end;

        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
