# -*- coding: utf-8 -*-
# @Time: 2020/6/30 14:52 
# @Author: GraceKoo
# @File: interview_30.py
# @Desc: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&
# qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return 0
        max_number = nums[0]
        for i in range(1, len(nums)):
            nums[i] += max(nums[i-1], 0)
            max_number = max(max_number, nums[i])
        return max_number


so = Solution()
print(so.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
