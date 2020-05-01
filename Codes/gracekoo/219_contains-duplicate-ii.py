# -*- coding: utf-8 -*-
# @Time: 2020/4/30 17:46
# @Author: GraceKoo
# @File: 219_contains-duplicate-ii.py
# @Desc: https://leetcode-cn.com/problems/contains-duplicate-ii/
from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        nums_sort = list()
        nums_sort.append(nums[0])
        for i in range(1, len(nums)):
            print(nums_sort)
            if nums[i] in nums_sort:
                return True
            elif len(nums_sort) >= k:
                nums_sort.pop(0)
            nums_sort.append(nums[i])
        return False


so = Solution()
print(so.containsNearbyDuplicate([1, 2, 3, 4, 2, 3], 2))
