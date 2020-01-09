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
        # 移动除数直到比被除数大
        while divisor <= dividend:
            move_step += 1
            divisor <<= 1
        # 移动move_step 次使得 len(divisor) > len(dividend),则 move_step-1 次使得 len(divisor) >  len(dividend)
        while move_step > 0:
            move_step -= 1
            # 此时divisor比division大，应该向右移动一位
            divisor >>= 1
            # 判断是否除尽
            if dividend >= divisor:
                result += 1 << move_step
                dividend -= divisor
        if not flag:
            result = -result
        return result if -(1 << 31) <= result <= (1 << 31) - 1 else (1 << 31) - 1


so = Solution()
print(so.divide(-45, 2))
