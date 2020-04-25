# -*- coding: utf-8 -*-
# @Time: 2020/4/23 21:18
# @Author: GraceKoo
# @File: 179_largest-number.py
# @Desc: https://leetcode-cn.com/problems/largest-number/
from typing import List


class LargerNumKey(str):
    def __lt__(x, y):
        return x + y < y + x


class Solution:
    def largestNumber(self, nums):
        return_value = "".join(
            sorted(map(str, nums), key=LargerNumKey, reverse=True)
        ).lstrip("0")
        return "0" if return_value[0] == "0" else return_value


so = Solution()
print(so.largestNumber([3, 30, 34, 5, 9]))
