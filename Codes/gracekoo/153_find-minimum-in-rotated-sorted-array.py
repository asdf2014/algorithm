# -*- coding: utf-8 -*-
# @Time: 2020/4/26 12:39
# @Author: GraceKoo
# @File: 153_find-minimum-in-rotated-sorted-array.py
# @Desc: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        len_nums = len(nums)
        if len_nums <= 1:
            return nums[0]
        left = 0
        right = len_nums - 1
        while left <= right:
            middle = (left + right) // 2
            # 退出条件
            if nums[middle - 1] > nums[middle]:
                return nums[middle]
            if nums[middle] > nums[middle + 1]:
                return nums[middle + 1]

            # 左边为有序，寻找在右边的变化点
            if nums[middle] > nums[left]:
                left = middle + 1
            # 右边为有序，寻找在左边的变化点
            else:
                right = middle - 1


so = Solution()
print(so.findMin([3, 4, 5, 1, 2]))
