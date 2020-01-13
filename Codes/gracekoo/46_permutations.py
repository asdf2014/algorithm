# -*- coding: utf-8 -*-
# @Time: 2020/1/13 6:40 下午
# @Author: GraceKoo
# @File: 46_permutations.py
# @Desc: https://leetcode-cn.com/problems/permutations/


class Solution:
    def permute(self, nums):
        def backtrack(nums, num):
            if not nums:
                output_list.append(num)
                return
            for i in range(len(nums)):
                backtrack(nums[:i] + nums[i + 1 :], num + [nums[i]])

        output_list = []
        backtrack(nums, [])
        return output_list


so = Solution()
print(so.permute([1, 2, 3]))
