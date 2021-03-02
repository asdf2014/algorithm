/**
 * ClassName:   Solution_92
 * Data:        2020/8/1
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
说明:
1 ≤ m ≤ n ≤ 链表长度。
示例:
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */
public class Solution_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode new_head = new ListNode(0);
        new_head.next = head;
        ListNode p1 = new_head, p2 = null;
        for (int i = 0; i <= n; i++) {
            if (i < m - 1) p1 = p1.next;
            if (i == m - 1) p2 = p1.next;
            if (i > m - 1 && i < n) {
                ListNode temp = p2.next;
                p2.next = temp.next;
                temp.next = p2;
                p1.next = temp;
                p1 = p1.next;
            }
        }
        return new_head.next;
    }
}
