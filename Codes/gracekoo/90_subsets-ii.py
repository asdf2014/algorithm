# -*- coding: utf-8 -*-
# @Time: 2020/4/4 22:57
# @Author: GraceKoo
# @File: 90_subsets-ii.py
# @Desc: https://leetcode-cn.com/problems/subsets-ii/
from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()

        def track_back(i, tmp):
            res.append(tmp)
            for j in range(i, n):
                if j > i and nums[j] == nums[j - 1]:
                    continue
                track_back(j + 1, tmp + [nums[j]])

        res = []
        track_back(0, [])
        return res


so = Solution()
print(so.subsetsWithDup([1, 2, 2]))
