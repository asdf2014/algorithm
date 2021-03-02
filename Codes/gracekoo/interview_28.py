# -*- coding: utf-8 -*-
# @Time: 2020/6/28 19:45
# @Author: GraceKoo
# @File: interview_28.py
# @Desc: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/

from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if not nums:
            return 0
        votes = 0
        count = 0
        for num in nums:
            if votes == 0:
                x = num
            votes += 1 if num == x else -1
        #  验证x是否为众数
        for _ in nums:
            if _ == x:
                count += 1
        return x if count > len(nums) // 2 else 0


so = Solution()
print(so.majorityElement([1, 2, 3, 2, 2, 2, 5, 4, 2]))
