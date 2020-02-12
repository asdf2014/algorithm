# -*- coding: utf-8 -*-
# @Time: 2020/2/11 8:36 下午
# @Author: GraceKoo
# @File: 41_first-missing-positive.py
# @Desc: https://leetcode-cn.com/problems/first-missing-positive/
from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        len_nums = len(nums)
        if 1 not in nums:
            return 1
        if len_nums == 1:
            return 2

        # 第一次遍历：将所有非法数字置为1
        for i in range(0, len_nums):
            if nums[i] <= 0 or nums[i] >= len_nums:
                nums[i] = 1

        # 第二次遍历：更改对应位置的符号
        for i in range(0, len_nums):
            val = abs(nums[i])
            nums[val] = -abs(nums[val])

        # 第三次遍历：遍历数组符号
        for i in range(1, len_nums):
            if nums[i] > 0:
                return i

        # 最后检查nums[0]
        if nums[0] > 0:
            return len_nums
        else:
            return len_nums + 1


so = Solution()
print(so.firstMissingPositive([7, 8, 9, 11, 12]))
