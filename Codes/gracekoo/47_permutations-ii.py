# -*- coding: utf-8 -*-
# @Time: 2020/2/18 6:40 下午
# @Author: GraceKoo
# @File: 47_permutations-ii.py
# @Desc: https://leetcode-cn.com/problems/permutations/


class Solution:
    def permuteUnique(self, nums):
        def backtrack(nums, num):
            if not nums:
                output_list.append(num)
                return
            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i - 1]:  # 每当进入新的构成，先考虑该构成的首字符是否和上一个一样。
                    continue
                backtrack(nums[:i] + nums[i + 1:], num + [nums[i]])

        nums.sort()  # 数组先排序
        output_list = []
        backtrack(nums, [])
        return output_list


so = Solution()
print(so.permuteUnique([1, 1, 2]))
