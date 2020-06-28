# -*- coding: utf-8 -*-
# @Time: 2020/5/26 12:35
# @Author: GraceKoo
# @File: interview_9.py
# @Desc: https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/
# coding-interviews&qru=/ta/coding-interviews/question-ranking


class Solution:
    def jumpFloorII(self, number):
        # write code here
        if number <= 1:
            return number
        n = 1
        for i in range(2, number + 1):
            n = 2 * n
        return n
