# -*- coding: utf-8 -*-
# @Time: 2020/9/28 16:16
# @Author: GraceKoo
# @File: interview_54.py
# @Desc: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/


class Solution:
    def __init__(self):
        self.char_appearing_dict = {}
        self.char_insert = []

    def FirstAppearingOnce(self):
        # write code here
        if not self.char_appearing_dict:
            return "#"
        for c in self.char_insert:
            if self.char_appearing_dict[c] == 1:
                return c
        return "#"

    def Insert(self, char):
        # write code here
        self.char_insert.append(char)
        if char in self.char_appearing_dict:
            self.char_appearing_dict[char] += 1
        else:
            self.char_appearing_dict[char] = 1
