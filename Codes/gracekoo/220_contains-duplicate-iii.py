# -*- coding: utf-8 -*-
# @Time: 2020/5/5 21:24
# @Author: GraceKoo
# @File: 220_contains-duplicate-iii.py
# @Desc: https://leetcode-cn.com/problems/contains-duplicate-iii
from typing import List


class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        if len(nums) <= 1:
            return False
        nums_sort = list()
        nums_sort.append(nums[0])
        for i in range(1, len(nums)):
            if len(nums_sort) > k:
                nums_sort.pop(0)
            # 查询当前子列表中的每个元素是否满足t的要求
            tmp_nums_sored = sorted(nums_sort, reverse=False)
            for v in tmp_nums_sored:
                if abs(nums[i] - v) <= t:
                    return True
            nums_sort.append(nums[i])
        return False


so = Solution()
print(so.containsNearbyAlmostDuplicate(nums=[1, 5, 9, 1, 5, 9], k=2, t=3))
