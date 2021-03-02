# -*- coding: utf-8 -*-
# @Time: 2020/9/23 18:33
# @Author: GraceKoo
# @File: interview_42.py
# @Desc: https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        i, j = 0, len(nums) - 1
        if j < 0:
            return nums
        while i != j:
            if nums[i] + nums[j] > target:
                # j 向右移动
                j -= 1
            elif nums[i] + nums[j] < target:
                # i 向左移动
                i += 1
            else:
                return [nums[i], nums[j]]
        return []


so = Solution()
print(so.twoSum([1, 2, 3, 4, 5], 7))
