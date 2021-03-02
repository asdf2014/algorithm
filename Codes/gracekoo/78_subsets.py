# -*- coding: utf-8 -*-
# @Time: 2020/3/24 11:57
# @Author: GraceKoo
# @File: 78_subsets.py
# @Desc:https://leetcode-cn.com/problems/subsets/
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        n = len(nums)
        if n <= 0:
            return result

        def backtrack(start, result_tmp):
            result.append(result_tmp)
            for i in range(start, n):
                backtrack(i + 1, result_tmp + [nums[i]])

        backtrack(0, [])
        return result


so = Solution()
print(so.subsets([1, 2, 3]))
