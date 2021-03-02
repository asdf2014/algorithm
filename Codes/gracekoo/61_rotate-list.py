# -*- coding: utf-8 -*-
# @Time: 2020/3/4 11:55
# @Author: GraceKoo
# @File: 61_rotate-list.py
# @Desc:https://leetcode-cn.com/problems/rotate-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head or head.next:
            return head
        length_of_nodes = 1
        old_tail = head

        # 1.compute the length of nodes
        while old_tail.next:
            length_of_nodes += 1
            old_tail = old_tail.next
        old_tail.next = head

        # 2.find the length_of_nodes - k % length_of_nodes -1 node,which is the last node
        new_tail = head
        for i in range(length_of_nodes - k % length_of_nodes - 1):
            new_tail = new_tail.next
        new_head = new_tail.next

        return new_head
