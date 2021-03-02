# -*- coding: utf-8 -*-
# @Time: 2020/4/27 12:46
# @Author: GraceKoo
# @File: 162_find-peak-element.py
# @Desc: https://leetcode-cn.com/problems/find-peak-element/
from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        while left < right:
            middle = (left + right) // 2
            # 从middle左侧开始找峰值
            if nums[middle] > nums[middle + 1]:
                right = middle
            # 从middle右侧开始找峰值
            else:
                left = middle + 1
        return left


so = Solution()
print(so.findPeakElement([1, 2, 1, 3, 5, 6, 4]))
