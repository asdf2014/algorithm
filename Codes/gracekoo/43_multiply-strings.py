# -*- coding: utf-8 -*-
# @Time: 2020/2/15 11:17
# @Author: GraceKoo
# @File: 43_multiply-strings.py
# @Desc: https://leetcode-cn.com/problems/multiply-strings/


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return 0
        return_sum = 0
        count = 0
        for val1 in num2[::-1]:
            add = 0  # 进位符
            multiply_sum = 0
            count1 = 0
            for val2 in num1[::-1]:
                multi_sum = (int(val1) * int(val2) + add) % 10
                multiply_sum += multi_sum * (10**count1)
                add = (int(val1) * int(val2) + add) // 10
                count1 += 1
            return_sum += multiply_sum * (10**count)
            count += 1

        return str(return_sum)


so = Solution()
print(so.multiply("123", "456"))
