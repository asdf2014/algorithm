# -*- coding: utf-8 -*-
# @Time: 2020/2/21 23:37
# @Author: GraceKoo
# @File: 50_powx-n.py
# @Desc:https://leetcode-cn.com/problems/powx-n/


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == -1:
            return 1 / x
        half = self.myPow(x, n // 2)
        if n % 2 == 0:
            return half * half
        else:
            return half * half * x


so = Solution()
print(so.myPow(2.00000, -10))
