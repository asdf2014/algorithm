# -*- coding: utf-8 -*-
# @Time: 2019/12/30 1:15 下午
# @Author: GraceKoo
# @File: 18_4Sum.py
# @Desc: https://leetcode-cn.com/problems/4sum/


class Solution:
    def fourSum(self, nums, target):
        nums = sorted(nums)
        if len(nums) < 4:
            return []
        elif sum(nums[:4]) > target:
            return []
        n = len(nums)
        result_li = []
        # 固定i与left，对middle与right进行查找与去重
        for i in range(n - 2):
            for left in range(i + 1, n - 1):
                middle = left + 1
                right = n - 1
                while middle != right:
                    sum_value = nums[i] + nums[left] + nums[middle] + nums[right]
                    if (
                        sum_value == target
                        and [nums[i], nums[left], nums[middle], nums[right]]
                        not in result_li
                    ):
                        result_li.append(
                            [nums[i], nums[left], nums[middle], nums[right]]
                        )
                    if sum_value <= target:
                        middle += 1
                        # 去重
                        while middle != right and nums[middle] == nums[middle - 1]:
                            middle += 1
                    else:
                        right -= 1
                        # 去重
                        while middle != right and nums[right] == nums[right + 1]:
                            right -= 1
        return result_li


so = Solution()
print(so.fourSum([1, 0, -1, 0, -2, 2], 0))
