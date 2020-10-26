# -*- coding: utf-8 -*-
# @Time: 2020/6/30 15:22
# @Author: GraceKoo
# @File: interview_50.py
# @Desc: https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&
# qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
from typing import List


class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        if not nums:
            return -1
        i = 0
        while i < len(nums):
            if nums[i] == i:
                i += 1
                continue
            if nums[i] == nums[nums[i]]:
                return nums[i]
            nums[nums[i]], nums[i] = nums[i], nums[nums[i]]

        return -1

