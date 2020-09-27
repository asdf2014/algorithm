# -*- coding: utf-8 -*-
# @Time: 2020/9/16 20:41 
# @Author: GraceKoo
# @File: interview_40.py
# @Desc: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
from typing import List


class Solution:
    def singleNumbers(self, nums: List[int]) -> List[int]:
        len_nums = len(nums)
        if len_nums <= 1:
            return nums
        output = []
        #  首先进行排序
        sort_nums = sorted(nums)
        i, j = 0, 1
        # i指向相同元素的第一个元素，j负责找与nums[i]不同的元素
        for j in range(1, len_nums):
            if sort_nums[i] != sort_nums[j]:
                # 如果不同元素是相邻的
                if j-i == 1:
                    output.append(sort_nums[i])
                    i = j
                # 如果不同元素不相邻，说明nums[i]有重复出现，则排除，将i指向当前j指向的元素
                if j-i > 1:
                    i = j
        # 判断最后一个元素是否重复
        if sort_nums[-1] != sort_nums[-2]:
            output.append(sort_nums[-1])
        return output


test_arr = [1, 289, 23, 23, 24]
so = Solution()
print(so.singleNumbers(test_arr))
