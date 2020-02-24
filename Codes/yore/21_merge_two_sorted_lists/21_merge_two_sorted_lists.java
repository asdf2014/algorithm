/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode point = root;
        int data1;
        int data2;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                data1 = l1.val;
                data2 = l2.val;
                if (data1 < data2) {
                    point.next = new ListNode(data1);
                    l1 = l1.next;
                } else {
                    point.next = new ListNode(data2);
                    l2 = l2.next;
                }
                point.next = new ListNode(data1 < data2 ? data1 : data2);

            } else if (l1 != null) {
                point.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                point.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            point = point.next;

        }
        return root.next;
    }
}
