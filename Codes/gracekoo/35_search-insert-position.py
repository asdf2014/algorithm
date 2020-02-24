# -*- coding: utf-8 -*-
# @Time: 2020/1/5 6:22 下午
# @Author: GraceKoo
# @File: 35_search-insert-position.py
# @Desc:https://leetcode-cn.com/problems/search-insert-position/


class Solution:
    def searchInsert(self, nums, target: int) -> int:
        for i in range(0, len(nums) - 1):
            if nums[i] == target:
                return i
            elif nums[i] < target <= nums[i + 1]:
                return i + 1
            elif nums[i] > target:
                return -1
        return len(nums)


so = Solution()
print(so.searchInsert([1, 3, 5, 6], 7))
