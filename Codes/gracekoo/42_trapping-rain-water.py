# -*- coding: utf-8 -*-
# @Time: 2020/2/14 09:11
# @Author: GraceKoo
# @File: 42_trapping-rain-water.py
# @Desc: https://leetcode-cn.com/problems/trapping-rain-water

from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        left, right = 0, len(height) - 1
        left_max, right_max = height[left], height[right]
        result = 0
        while left < right:
            # 因为是从0，size-1开始比较的，每次比较相当于间接确定了height[left] < height[left_max] < height[right]
            # 计算左边
            if height[left] < height[right]:
                # 更新左边的最大值
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    result += left_max - height[left]
                left += 1
            # height[right] < height[right_max] < height[left]
            # 计算右边
            else:
                # 更新右边的最大值
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    result += right_max - height[right]
                right -= 1
        return result


so = Solution()
print(so.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
