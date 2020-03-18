# -*- coding: utf-8 -*-
# @Time: 2020/3/18 23:41
# @Author: GraceKoo
# @File: 75_sort-colors.py
# @Desc:https://leetcode-cn.com/problems/sort-colors
from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> List:
        if len(nums) <= 1:
            return nums
        left = 0
        right = len(nums) - 1
        current = 0
        while left <= right:
            if nums[current] == 0:
                nums[left], nums[current] = nums[current], nums[left]
                left += 1
                current += 1
            elif nums[current] == 1:
                nums[right], nums[current] = nums[current], nums[right]
                right -= 1
            else:
                current += 1
        return nums


so = Solution()
print(so.sortColors([2, 0, 2, 1, 1, 0]))
