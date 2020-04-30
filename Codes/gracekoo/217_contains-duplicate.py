# -*- coding: utf-8 -*-
# @Time: 2020/4/30 17:45
# @Author: GraceKoo
# @File: 217_contains-duplicate.py
# @Desc: https://leetcode-cn.com/problems/contains-duplicate/
from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        if not nums:
            return False
        # 先排序
        nums.sort(reverse=False)
        # 再比较
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                return True
        return False


so = Solution()
print(so.containsDuplicate([1, 2, 3, 1, 2, 3]))
