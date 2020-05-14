# -*- coding: utf-8 -*-
# @Time: 2020/5/14 12:38
# @Author: GraceKoo
# @File: 509_fibonacci-number.py
# @Desc: https://leetcode-cn.com/problems/fibonacci-number/


class Solution:
    def fib(self, N: int) -> int:
        if N <= 1:
            return N
        f_dict = {0: 0, 1: 1}
        for i in range(2, N):
            f_dict[i] = f_dict[i - 1] + f_dict[i - 2]
        return f_dict[N - 1]


so = Solution()
print(so.fib(4))
