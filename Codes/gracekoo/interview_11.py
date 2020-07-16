# -*- coding: utf-8 -*-
# @Time: 2020/7/16 15:41
# @Author: GraceKoo
# @File: interview_11.py
# @Desc: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/


class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n:
            res += n & 1
            n >>= 1
        return res


so = Solution()
print(so.hammingWeight(-1))
