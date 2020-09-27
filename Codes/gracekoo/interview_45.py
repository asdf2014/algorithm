# -*- coding: utf-8 -*-
# @Time: 2020/9/24 15:16 
# @Author: GraceKoo
# @File: interview_45.py
# @Desc: https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
from typing import List


class Solution:
    def isStraight(self, nums: List[int]) -> bool:
        if not nums:
            return False
        joker = 0
        nums.sort()
        for i in range(len(nums) - 1):
            if nums[i] == 0:
                joker += 1
            elif nums[i] == nums[i + 1]:
                return False
        return nums[4] - nums[joker] < 5


so = Solution()
print(so.isStraight([0, 0, 1, 2, 5]))
