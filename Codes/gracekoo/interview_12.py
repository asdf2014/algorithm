# -*- coding: utf-8 -*-
# @Time: 2020/7/16 16:24
# @Author: GraceKoo
# @File: interview_12.py
# @Desc: https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&q
# ru=%2Fta%2Fcoding-interviews%2Fquestion-ranking


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
