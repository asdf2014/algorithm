# -*- coding: utf-8 -*-
# @Time: 2020/2/17 09:45
# @Author: GraceKoo
# @File: 45_jump-game-ii.py
# @Desc: https://leetcode-cn.com/problems/jump-game-ii/
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        max_position = 0  # 记录局部可跳跃的最大值
        end = 0  # 记录每次跳跃的最大值的下标
        step = 0  # 记录跳跃的步数
        if len(nums) < 2:
            return step
        for i in range(len(nums)-1):
            # 寻找局部最优解
            max_position = max(max_position, nums[i] + i)
            if i == end:
                end = max_position
                step += 1
        return step


so = Solution()
print(so.jump([2, 3, 1, 1, 4]))
