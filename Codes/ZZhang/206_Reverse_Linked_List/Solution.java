//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
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

class Solution {
    public ListNode reverseList(ListNode head) {

        // iterate;
//        return iter(head);
        // recursive
        return recusive(head);

    }

    private ListNode recusive(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) return newHead;

        ListNode nextNode = head.next;
        head.next = newHead;
        return reverse(nextNode, head);
    }

    private ListNode iter(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)