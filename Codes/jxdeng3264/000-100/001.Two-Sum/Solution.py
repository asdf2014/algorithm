#!/usr/bin/env python3
# encoding: utf-8
# author: pyclearl

"""
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""


class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype List[int]

        >>> s = Solution()
        >>> nums = [2, 7, 11, 15]
        >>> target = 9
        >>> s.twoSum(nums, target)
        [0, 1]

        Because nums[0] + nums[1] = 2 + 7 = 9,
        """
        for i, n in enumerate(nums):
            try:
                # 求n的补在nums中是否存在, 存在就返回，可能越界
                index = nums.index(target - n)
                if index != i:
                    return [i, index]
            except ValueError as e:
                pass


if __name__ == '__main__':
    import doctest
    doctest.testmod(verbose=True)
