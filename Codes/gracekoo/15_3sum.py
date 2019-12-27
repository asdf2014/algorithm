# -*- coding: utf-8 -*-
# @Time: 2019/12/27 12:18 上午
# @Author: GraceKoo
# @File: 15_3sum.py
# @Desc: https://leetcode-cn.com/problems/3sum/


class Solution:
    def threeSum(self, nums):
        if not nums or len(nums) < 3:
            return []
        n = len(nums)
        output = []
        nums.sort()
        for i in range(0, n):
            if nums[i] > 0:
                return output
            if i > 0 and nums[i] == nums[i-1]:
                continue
            left = i + 1
            right = n - 1
            while left < right:
                if nums[i] + nums[left] + nums[right] == 0:
                    output.append((nums[i], nums[left], nums[right]))
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif nums[i] + nums[left] + nums[right] > 0:
                    right -= 1
                else:
                    left += 1
        return output


so = Solution()
print(so.threeSum([-1, 0, 1, 2, -1, -4]))

