# -*- coding: utf-8 -*-
# @Time: 2020/6/7 23:44
# @Author: GraceKoo
# @File: interview_31.py
# @Desc: https://leetcode-cn.com/problems/
# zhan-de-ya-ru-dan-chu-xu-lie-lcof/
from typing import List


class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        i_pop = 0
        stack = []
        for value in pushed:
            stack.append(value)
            while stack and popped[i_pop] == stack[-1]:
                stack.pop()
                i_pop += 1
        return not stack


so = Solution()
print(so.validateStackSequences(pushed=[1, 2, 3, 4, 5], popped=[4, 5, 3, 2, 1]))
