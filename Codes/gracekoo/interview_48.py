# -*- coding: utf-8 -*-
# @Time: 2020/9/25 14:37
# @Author: GraceKoo
# @File: interview_48.py
# @Desc: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/


class Solution:
    def add(self, a: int, b: int) -> int:
        a &= 0xFFFFFFFF
        b &= 0xFFFFFFFF
        while b != 0:
            c = ((a & b) << 1) & 0xFFFFFFFF  # 进位用与操作
            a ^= b  # 不考虑进位的结果用异或操作
            b = c
        return a if a <= 0x7FFFFFFF else ~(a ^ 0xFFFFFFFF)  # 负数需要恢复成原码


so = Solution()
print(so.add(-3, -2))
