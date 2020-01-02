# -*- coding: utf-8 -*-
# @Time: 2020/1/2 11:53 下午
# @Author: GraceKoo
# @File: 26_remove-duplicates-from-sorted-array.py
# @Desc: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/


class Solution:
    def removeDuplicates(self, nums):
        if len(nums) == 0:
            return 0
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1


so = Solution()
print(so.removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]))
