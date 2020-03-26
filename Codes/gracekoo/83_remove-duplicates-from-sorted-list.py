# -*- coding: utf-8 -*-
# @Time: 2020/3/26 23:28 
# @Author: GraceKoo
# @File: 83_remove-duplicates-from-sorted-list.py
# @Desc:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        tmp = head
        while tmp and tmp.next:
            if tmp.val == tmp.next.val:
                tmp.next = tmp.next.next
            else:
                tmp = tmp.next
        return head

first_node = ListNode(0)
first_node.next = ListNode(2)
first_node.next.next = ListNode(2)
print(first_node.val, first_node.next.val, first_node.next.next.val)
so = Solution()
last_node = so.deleteDuplicates(first_node)
while last_node:
    print(last_node.val)
    last_node = last_node.next
