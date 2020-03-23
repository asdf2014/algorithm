# -*- coding: utf-8 -*-
# @Time: 2020/3/22 23:19 
# @Author: GraceKoo
# @File: 206_reverse-linked-list.py
# @Desc:https://leetcode-cn.com/problems/reverse-linked-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return None
        pre_node = None
        current_node = head
        while current_node:
            current_node.next, pre_node, current_node = pre_node, current_node, current_node.next
        return pre_node


first_node = ListNode(0)
first_node.next = ListNode(1)
first_node.next.next = ListNode(2)
print(first_node.val, first_node.next.val, first_node.next.next.val)

so = Solution()
last_node = so.reverseList(first_node)
print(last_node.val, last_node.next.val, last_node.next.next.val)


