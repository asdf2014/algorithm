# -*- coding: utf-8 -*-
# @Time: 2020/6/7 21:36
# @Author: GraceKoo
# @File: interview_30.py
# @Desc: https://leetcode-cn.com/problems/
# bao-han-minhan-shu-de-zhan-lcof/


class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.mins = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if not self.mins or x <= self.mins[-1]:
            self.mins.append(x)

    def pop(self) -> None:
        if not self.stack:
            return
        x = self.stack.pop()
        if self.mins and self.mins[-1] == x:
            self.mins.pop()

    def top(self) -> int:
        return self.stack and self.stack[-1]

    def min(self) -> int:
        return self.mins and self.mins[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.min()
