# -*- coding: utf-8 -*-
# @Time: 2020/9/24 15:16 
# @Author: GraceKoo
# @File: interview_47.py
# @Desc: https://leetcode-cn.com/problems/qiu-12n-lcof/


class Solution:
    def __init__(self):
        self.res = 0

    def sumNums(self, n: int) -> int:
        n > 1 and self.sumNums(n-1)
        self.res += n
        return self.res


so = Solution()
print(so.sumNums(3))
