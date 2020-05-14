# -*- coding: utf-8 -*-
# @Time: 2020/5/14 12:38 
# @Author: GraceKoo
# @File: 509_fibonacci-number.py
# @Desc: https://leetcode-cn.com/problems/fibonacci-number/


class Solution:
    def fib(self, N: int) -> int:
        if N == 0:
            return 0
        if N == 1:
            return 1
        return self.fib(N-1) + self.fib(N-2)


so = Solution()
print(so.fib(4))
