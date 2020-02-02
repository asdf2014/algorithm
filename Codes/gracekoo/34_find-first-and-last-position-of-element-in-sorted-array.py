# -*- coding: utf-8 -*-
# @Time: 2020/2/2 11:18 上午 
# @Author: GraceKoo
# @File: 34_find-first-and-last-position-of-element-in-sorted-array.py
# @Desc: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/


class Solution:
    def find_left_right_index(self, nums, target, left_right_flag):
        left, right = 0, len(nums)
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > target or (left_right_flag and nums[mid] == target):
                right = mid
            else:
                left = mid + 1
        return left

    def searchRange(self, nums, target: int):
        left_index = self.find_left_right_index(nums, target, True)
        if left_index == len(nums) or nums[left_index] != target:
            return [-1, -1]
        return [left_index, self.find_left_right_index(nums, target, False) - 1]


so = Solution()
print(so.searchRange([5, 7, 7, 8, 8, 10], 8))
