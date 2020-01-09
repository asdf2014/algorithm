# -*- coding: utf-8 -*-
# @Time: 2020/1/9 9:11 下午
# @Author: GraceKoo
# @File: 29_divide-two-integers.py
# @Desc:https://leetcode-cn.com/problems/divide-two-integers/


class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        flag = dividend < 0 ^ divisor < 0
        dividend, divisor = abs(dividend), abs(divisor)
        result = 0
        move_step = 0
        while divisor <= dividend:
            move_step += 1
            divisor <<= 1
        while move_step > 0:
            move_step -= 1
            divisor >>= 1
            if dividend >= divisor:
                result += 1 << move_step
                dividend -= divisor
        if not flag:
            result = -result
        return result if -(1 << 31) <= result <= (1 << 31) - 1 else (1 << 31) - 1


so = Solution()
print(so.divide(-45, 2))
