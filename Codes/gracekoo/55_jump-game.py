# -*- coding: utf-8 -*-
# @Time: 2020/2/27 12:08
# @Author: GraceKoo
# @File: 55_jump-game.py
# @Desc:https://leetcode-cn.com/problems/jump-game/
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        last_true_index = nums[-1]
        for i in range(len(nums) - 1, 0, -1):
            if i + nums[i] >= last_true_index:
                last_true_index = nums[i]
            else:
                return False
        return True


so = Solution()
print(so.canJump([2, 3, 1, 1, 4]))
