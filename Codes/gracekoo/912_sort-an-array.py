# -*- coding: utf-8 -*-
# @Time: 2020/4/28 22:52 
# @Author: GraceKoo
# @File: 912_sort-an-array.py
# @Desc: https://leetcode-cn.com/problems/sort-an-array/
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        n = len(nums)

        #  快速排序
        def quick(left, right):
            if left >= right:
                return nums
            # 哨兵
            pivot = left
            i = left
            j = n - 1
            while i < j:
                # 寻找右半部分
                while i < j and nums[j] > nums[pivot]:
                    j -= 1
                # 寻找左半部分
                while i < j and nums[i] <= nums[pivot]:
                    i += 1
                nums[i], nums[j] = nums[j], nums[i]
            nums[pivot], nums[j] = nums[j], nums[pivot]
            quick(left, j-1)
            quick(j+1, right)
            return nums

        return quick(0, n - 1)


so = Solution()
print(so.sortArray([5, 1, 1, 2, 0, 0]))
