# -*- coding: utf-8 -*-
# @Time: 2020/2/22 19:31
# @Author: GraceKoo
# @File: 66_plus-one.py
# @Desc:https://leetcode-cn.com/problems/plus-one/
from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if not digits:
            return []
        len_digits = len(digits)
        add = (digits[len_digits - 1] + 1) // 10
        digits[len_digits - 1] = (digits[len_digits - 1] + 1) % 10

        for i in range(len_digits - 2, -1, -1):
            add = (digits[i] + add) // 10
            digits[i] = (digits[i] + add) % 10
        if add == 1:
            digits.insert(0, add)
        return digits


so = Solution()
print(so.plusOne([9, 9, 9, 9]))
