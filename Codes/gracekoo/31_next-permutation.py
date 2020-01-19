# -*- coding: utf-8 -*-
# @Time: 2020/1/19 12:18 下午 
# @Author: GraceKoo
# @File: 31_next-permutation.py
# @Desc:


class Solution:
    def nextPermutation(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return []
        left = -1
        for i in range(len(nums)-1, 0, -1):
            # 从右开始，找到第一个升序的数
            if nums[i - 1] < nums[i]:
                left = i - 1
                break
        # 如果不存在left，则为降序数列，翻转整个数组
        if left == -1:
            return nums[::-1]

        # 否则找到第一个比nums[left]大的数，至少有一个（为nums[left+1]）
        for right in range(len(nums)-1, left, -1):
            if nums[right] > nums[left]:
                nums[right], nums[left] = nums[left], nums[right]
                break
        # 此时nums[left+1]依旧为降序数列，翻转nums[left+1]
        nums_left = nums[left + 1:len(nums)]
        nums_left = nums_left[::-1]
        nums[left + 1:len(nums)] = nums_left
        return nums


so = Solution()
print(so.nextPermutation([1, 2, 3, 7, 4]))
