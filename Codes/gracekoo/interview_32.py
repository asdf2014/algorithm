# -*- coding: utf-8 -*-
# @Time: 2020/7/2 11:54 
# @Author: GraceKoo
# @File: interview_32.py
# @Desc: https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
from typing import List


class Solution(object):
    def minNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        if not nums:
            return None
        for i in range(len(nums)):
            nums[i] = str(nums[i])
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if (nums[i] + nums[j]) > (nums[j] + nums[i]):
                    nums[i], nums[j] = nums[j], nums[i]

        return ''.join(nums)


so = Solution()
print(so.minNumber([3, 30, 34, 5, 9]))
