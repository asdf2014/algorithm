# -*- coding: utf-8 -*-
# @Time: 2020/4/9 23:07
# @Author: GraceKoo
# @File: 87_scramble-string.py
# @Desc:https://leetcode-cn.com/problems/scramble-string/
import functools


class Solution:
    @functools.lru_cache(None)
    def isScramble(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False
        if s1 == s2:
            return True
        if sorted(s1) != sorted(s2):
            return False
        for i in range(1, len(s1)):
            if self.isScramble(s1[:i], s2[:i]) and self.isScramble(s1[i:], s2[i:]):
                return True
            if self.isScramble(s1[:i], s2[-i:]) and self.isScramble(s1[i:], s2[:-i]):
                return True
        return False


so = Solution()
print(so.isScramble("great", "rgtae"))
