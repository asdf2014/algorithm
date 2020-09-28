# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16 
# @Author: GraceKoo
# @File: interview_54.py
# @Desc: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/


class Solution:
    def firstUniqChar(self, s: str) -> str:
        result_dict = {}
        for item in s:
            result_dict[item] = item not in result_dict
        for k, v in result_dict.items():
            if v:
                return k
        return " "