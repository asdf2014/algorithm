# -*- coding: utf-8 -*-
# @Time: 2020/3/11 11:57
# @Author: GraceKoo
# @File: 69_sqrtx.py
# @Desc:https://leetcode-cn.com/problems/sqrtx/


class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        left = 2
        right = x // 2
        while left <= right:
            middle = left + (right - left) // 2
            if middle * middle > x:
                right = middle - 1
            elif middle * middle < x:
                left = middle + 1
            else:
                return middle
        return right


so = Solution()
print(so.mySqrt(8))
