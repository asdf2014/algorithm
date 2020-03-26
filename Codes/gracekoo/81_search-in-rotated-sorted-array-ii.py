# -*- coding: utf-8 -*-
# @Time: 2020/3/26 19:16 
# @Author: GraceKoo
# @File: 81_search-in-rotated-sorted-array-ii.py
# @Desc:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/


class Solution:
    def search(self, nums, target: int) -> int:
        if not nums:
            return False
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return True
            # 右半部分是有序的
            if nums[mid] < nums[right]:
                # target在右半部分里
                if nums[mid] < target < nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            # 左半部分是有序的
            else:
                # target在左半部分里
                if nums[left] < target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
        return False


so = Solution()
print(so.search([2, 5, 6, 0, 0, 1, 2], 3))
