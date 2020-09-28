# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16 
# @Author: GraceKoo
# @File: interview_55.py
# @Desc: https://leetcode-cn.com/problems/linked-list-cycle/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool: