# -*- coding: utf-8 -*-
# @Time: 2020/2/25 09:52
# @Author: GraceKoo
# @File: 53_maximum-subarray.py
# @Desc:https://leetcode-cn.com/problems/maximum-subarray/
from typing import List


class Solution:
    def maxSubArray_GA(self, nums: List[int]) -> int:
        len_nums = len(nums)
        current_sum = max_sum = nums[0]
        for i in range(1, len_nums):
            # 寻找局部最优解
            current_sum = max(nums[i], current_sum + nums[i])
            max_sum = max(max_sum, current_sum)
        return max_sum

    def maxSubArray_DP(self, nums: List[int]) -> int:
        len_nums = len(nums)
        max_sum = nums[0]
        for i in range(1, len_nums):
            if nums[i - 1] > 0:
                nums[i] += nums[i - 1]
            max_sum = max(max_sum, nums[i])
        return max_sum


so = Solution()
print(so.maxSubArray_GA([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
print(so.maxSubArray_DP([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
