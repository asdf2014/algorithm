# -*- coding: utf-8 -*-
# @Time: 2020/2/1 4:43 下午 
# @Author: GraceKoo
# @File: 33_search-in-rotated-sorted-array.py
# @Desc: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/


class Solution:
    def search(self, nums, target: int) -> int:
        if not nums:
            return -1
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
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
        return -1


so = Solution()
print(so.search([4, 5, 6, 7, 0, 1, 2], 0))
