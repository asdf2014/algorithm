# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16 
# @Author: GraceKoo
# @File: interview_56.py
# @Desc: https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&
# qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplication(self, pHead):
        # write code here