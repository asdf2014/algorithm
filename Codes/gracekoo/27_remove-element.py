# -*- coding: utf-8 -*-
# @Time: 2020/1/3 11:41 下午
# @Author: GraceKoo
# @File: 27_remove-element.py
# @Desc:https://leetcode-cn.com/problems/remove-element/


class Solution:
    def removeElement(self, nums, val: int):
        if not nums:
            return 0
        i = 0
        for j in range(0, len(nums)):
            if nums[j] != val:
                nums[i] = nums[j]
                i += 1
        return i


so = Solution()
print(so.removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2))
