# -*- coding: utf-8 -*-
# @Time: 2020/1/6 5:15 下午
# @Author: GraceKoo
# @File: 24_swap-nodes-in-pairs.py
# @Desc:https://leetcode-cn.com/problems/swap-nodes-in-pairs/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        head_pre = ListNode(-1)
        head_pre.next = head
        tmp = head_pre
        while tmp.next and tmp.next.next:
            a, b = tmp.next, tmp.next.next
            tmp.next, a.next = b, b.next
            b.next = a
            tmp = tmp.next.next
        return head_pre.next
