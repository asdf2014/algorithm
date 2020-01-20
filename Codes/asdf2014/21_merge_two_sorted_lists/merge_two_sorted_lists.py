# https://leetcode.com/problems/merge-two-sorted-lists/

# Merge two sorted linked lists and return it as a new list. The new list should
# be made by splicing together the nodes of the first two lists.
#
# Example:
# Input: 1->2->4, 1->3->4
# Output: 1->1->2->3->4->4
#
# Related Topics Linked List


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def merge_two_sorted_lists(l1: ListNode, l2: ListNode) -> ListNode:
    root = tmp = ListNode(None)
    while l1 is not None or l2 is not None:
        if l2 is None:
            tmp.next = l1
            l1 = l1.next
        elif l1 is None:
            tmp.next = l2
            l2 = l2.next
        else:
            if l1.val < l2.val:
                tmp.next = l1
                l1 = l1.next
            else:
                tmp.next = l2
                l2 = l2.next
        tmp = tmp.next
    return root.next


l1_0 = ListNode(1)
l1_1 = ListNode(2)
l1_2 = ListNode(4)
l1_0.next = l1_1
l1_1.next = l1_2

l2_0 = ListNode(1)
l2_1 = ListNode(3)
l2_2 = ListNode(4)
l2_0.next = l2_1
l2_1.next = l2_2

l3_0 = ListNode(1)
l3_1 = ListNode(1)
l3_2 = ListNode(2)
l3_3 = ListNode(3)
l3_4 = ListNode(4)
l3_5 = ListNode(4)
l3_0.next = l3_1
l3_1.next = l3_2
l3_2.next = l3_3
l3_3.next = l3_4
l3_4.next = l3_5


def is_same_list(l1: ListNode, l2: ListNode) -> bool:
    while l1 is not None or l2 is not None:
        if l1 is None or l2 is None or l1.val is not l2.val:
            return False
        l1 = l1.next
        l2 = l2.next
    return True


# noinspection PyTypeChecker
assert is_same_list(merge_two_sorted_lists(None, ListNode(0)), ListNode(0))
assert is_same_list(merge_two_sorted_lists(l1_0, l2_0), l3_0)
