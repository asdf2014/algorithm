# -*- coding: utf-8 -*-
# @Time: 2020/3/31 23:09 
# @Author: GraceKoo
# @File: 86_partition-list.py
# @Desc:https://leetcode-cn.com/problems/partition-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if not head:
            return head
        # before_node、after_node是哑节点
        before = before_node = ListNode(0)
        after = after_node = ListNode(0)
        while head:
            if head.val > x:
                after.next = head
                after = after.next
            else:
                before.next = head
                before = before.next
            head = head.next
        after.next = None
        before.next = after_node.next

        return before_node.next


