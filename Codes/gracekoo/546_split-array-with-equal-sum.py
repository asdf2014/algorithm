# -*- coding: utf-8 -*-
# @Time: 2020/5/13 12:33
# @Author: GraceKoo
# @File: 546_split-array-with-equal-sum.py
# @Desc: https://leetcode-cn.com/problems/split-array-with-equal-sum/
from typing import List


class Solution:
    def splitArray(self, nums: List[int]) -> bool:
        len_nums = len(nums)
        if len_nums < 7:
            return False
        sum_list = list()
        sum_list.append(nums[0])
        for i in range(1, len_nums):
            sum_list.append(sum_list[i - 1] + nums[i])
        # 用中间的j去约定i与k的范围
        for j in range(3, len_nums - 3):
            sum_set = set()
            for i in range(1, j - 1):
                if sum_list[i - 1] == sum_list[j - 1] - sum_list[i]:
                    sum_set.add(sum_list[i - 1])
            for k in range(j + 2, len_nums - 1):
                if (
                    sum_list[-1] - sum_list[k] == sum_list[k - 1] - sum_list[j]
                    and (sum_list[k - 1] - sum_list[j]) in sum_set
                ):
                    return True
        return False


so = Solution()
print(so.splitArray([1, 2, 1, 2, 1, 2, 1]))
