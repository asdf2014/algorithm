/**
 * 解题思路：
 *   因为链表中是以逆序的形式存放数字，所以采用同时从表头开始遍历列表，用一个额外内存空间存储进位
 *   遍历的过程中做对应位加法运算（注意进位），同时构建结果链表元素
 *   遍历结束标志： 两个链表的next指针均位空
 * @param l1 数字1
 * @param l2 数字2
 * @return 相加结果
 */
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode pointNode = result;
    int carry = 0;
    while (l1 != null || l2 != null) {
        int a = l1 != null ? l1.val : 0;
        int b = l2 != null ? l2.val : 0;
        int sum = a + b + carry;
        carry = sum / 10;
        pointNode.next = new ListNode(sum % 10);
        pointNode = pointNode.next;
        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
    }
    if (carry > 0) {
        pointNode.next = new ListNode(carry);
    }
    return result.next;
}
