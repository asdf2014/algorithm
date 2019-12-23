# -*- coding: utf-8 -*-
# URL : https://leetcode.com/problems/two-sum/

""""""

"""
problem:
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
"""

"""
explain:
nums中每两个相加，如果等于target就返回，那需要遍历(n^2)。
作差值计算，比如9-2==7，就是说2需要7，
再判定7是否已经作了差值计算了，如果有那就返回下标，完成计算；如果没有，就存在已经进行差值计算的dict中。
所以这些差值需要额外的空间存储，其中的元素应当含有原数组的值和下标。
"""

"""
out:
执行用时 :36 ms, 在所有 Python 提交中击败了99.70%的用户
内存消耗 :13.1 MB, 在所有 Python 提交中击败了14.79%的用户
"""


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        difference_value_dict = dict()
        for index, num in enumerate(nums):
            difference_value = target - num
            if difference_value in difference_value_dict:
                return [difference_value_dict[difference_value], index]
            difference_value_dict[num] = index


if __name__ == "__main__":
    solution = Solution()
    assert solution.twoSum([2, 7, 11, 15], 9) == [0, 1]
    assert solution.twoSum([4, 7, 0, 3], 3) == [2, 3]
