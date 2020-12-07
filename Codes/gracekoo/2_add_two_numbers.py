# -*- coding: utf-8 -*-
# @Time : 2019/9/1111:11 下午
# @Author: GraceKoo
# @File:  2_add_two_numbers.py
# @Desc: https://leetcode-cn.com/problems/add-two-numbers/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None and l2 is None:
            return None
        elif l1 is None:
            return l2
        elif l2 is None:
            return l1
        flag = 0
        tmp = ListNode(0)
        res = tmp
        while l1 or l2:
            tmp_sum = 0
            if l1:
                tmp_sum += l1.val
                l1 = l1.next
            if l2:
                tmp_sum += l2.val
                l2 = l2.next
            flag = (tmp_sum + flag) // 10
            tmp_sum = (tmp_sum + flag) % 10
            res.next = ListNode(tmp_sum)
            res = res.next
        if flag:
            res.mext = ListNode(1)
        res = tmp.next
        del tmp

        return res
