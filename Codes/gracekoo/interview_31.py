# -*- coding: utf-8 -*-
# @Time: 2020/7/2 11:50
# @Author: GraceKoo
# @File: interview_31.py
# @Desc: https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/


class Solution:
    def countDigitOne(self, n: int) -> int:
        s = ""
        while n:
            s += str(n)
            n -= 1
        return s.count("1")


so = Solution()
print(so.countDigitOne(12))
