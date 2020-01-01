# -*- coding: utf-8 -*-
# @Time: 2020/1/1 9:04 下午
# @Author: GraceKoo
# @File: 21_merge-two-sorted-lists.py
# @Desc: https://leetcode-cn.com/problems/merge-two-sorted-lists/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        head_pre = ListNode(-1)
        pre = head_pre
        while l1 or l2:
            if l1.value < l2.value:
                pre.next = l1
                l1 = l1.next
            else:
                pre.next = l2
                l2 = l2.next
            # pre指向当前计算节点的上一个节点，运算结束后需指向下一个
            pre = pre.next
        pre.next = l1 if l1 is not None else l2

        return head_pre.next

