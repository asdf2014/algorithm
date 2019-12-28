# -*- coding: utf-8 -*-
# @Time: 2019/12/28 4:32 下午
# @Author: GraceKoo
# @File: 16_3sum-closest.py
# @Desc: https://leetcode-cn.com/problems/3sum-closest/


class Solution:
    def threeSumClosest(self, nums, target) -> int:
        if not nums or len(nums) < 3:
            return 0
        nums.sort()
        n = len(nums)
        result = nums[0] + nums[1] + nums[2]
        for i in range(0, n - 2):
            left = i + 1
            right = n - 1
            while left < right:
                min_value = nums[i] + nums[left] + nums[left + 1]
                # 最小的都比target大，后面的元素则无需进行比较
                if target < min_value:
                    if abs(min_value - target) < abs(result - target):
                        result = min_value
                    break
                # 最大的都比target小，前面的元素则无需进行比较
                max_value = nums[i] + nums[right] + nums[right - 1]
                if target > max_value:
                    if abs(max_value - target) < abs(result - target):
                        result = max_value
                    break
                sum_value = nums[i] + nums[left] + nums[right]
                if abs(sum_value - target) < abs(result - target):
                    result = sum_value
                if sum_value == target:
                    return sum_value
                if sum_value > target:
                    right -= 1
                    # 去重
                    while (not left == right) and nums[right] == nums[right + 1]:
                        right -= 1
                else:
                    left += 1
                    while (not left == right) and nums[left] == nums[left - 1]:
                        left += 1
            # 去重
            while i < n - 2 and nums[i] == nums[i + 1]:
                i += 1
        return result


so = Solution()
print(so.threeSumClosest([-1, 2, 1, -4], 1))
