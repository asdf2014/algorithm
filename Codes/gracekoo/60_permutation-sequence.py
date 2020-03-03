# -*- coding: utf-8 -*-
# @Time: 2020/3/2 12:07
# @Author: GraceKoo
# @File: 60_permutation-sequence.py
# @Desc:https://leetcode-cn.com/problems/permutation-sequence/
import math


class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        nums = [str(i) for i in range(1, n + 1)]
        output_str = ""
        n -= 1
        while n > -1:
            number_combination = math.factorial(n)  # 每组组合数总和
            output_number_index = (
                math.ceil(k / number_combination) - 1
            )  # 不用\\的原因是因为 1 1希望输出的是0，"\\"会输出1
            output_str += nums[output_number_index]
            nums.pop(output_number_index)
            k %= number_combination
            n -= 1
        return output_str


so = Solution()
print(so.getPermutation(4, 9))
