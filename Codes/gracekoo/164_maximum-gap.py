# -*- coding: utf-8 -*-
# @Time: 2020/4/29 12:39
# @Author: GraceKoo
# @File: 164_maximum-gap.py
# @Desc: https://leetcode-cn.com/problems/maximum-gap/
from typing import List


class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        len_nums = len(nums)
        if len_nums < 2:
            return 0
        nums.sort(reverse=False)
        max_gap = abs(nums[1] - nums[0])
        for i in range(2, len_nums):
            max_gap = max(max_gap, abs(nums[i] - nums[i - 1]))
        return max_gap


so = Solution()
print(so.maximumGap([3, 6, 9, 1]))
