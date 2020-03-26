# -*- coding: utf-8 -*-
# @Time: 2020/3/26 14:00
# @Author: GraceKoo
# @File: 80_remove-duplicates-from-sorted-array-ii.py
# @Desc:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        j, count = 1, 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                count += 1
            else:
                count = 1

            if count <= 2:
                nums[j] = nums[i]
                j += 1
        return j


so = Solution()
print(so.removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3]))
