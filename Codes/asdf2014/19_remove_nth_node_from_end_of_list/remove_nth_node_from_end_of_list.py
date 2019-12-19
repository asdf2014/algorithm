# https://leetcode.com/problems/remove-nth-node-from-end-of-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def remove_nth_node_from_end_of_list(head: ListNode, n: int) -> ListNode:
    tmp = head
    count = 0
    while tmp:
        count += 1
        tmp = tmp.next
    n = count + 1 - n
    if n <= 0:
        return head
    if n is 1:
        return head.next
    tmp = head
    for _ in range(n - 2):
        tmp = tmp.next
    tmp.next = tmp.next.next
    return head


n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n5 = ListNode(5)
n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5

res = remove_nth_node_from_end_of_list(n1, 2)
assert res.val is 1
assert res.next.val is 2
assert res.next.next.val is 3
assert res.next.next.next.val is 5
