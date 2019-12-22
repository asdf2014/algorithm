# -*- coding: utf-8 -*-
# @Time: 2019/12/21 7:46 下午
# @Author: GraceKoo
# @File: 10_regular-expression-matchin.py
# @Desc:https://leetcode-cn.com/problems/regular-expression-matching/


class Solution(object):
    def isMatch(self, s, p):
        if not p:
            return not s
        match = s and p[0] in [s[0], "."]  # p[0] == s[0] or == "."
        if len(p) > 1 and p[1] == "*":  # p[1] == "*"
            return self.isMatch(s, p[2:]) or (match and self.isMatch(s[1:], p))
        return match and self.isMatch(s[1:], p[1:])


so = Solution()
assert so.isMatch("mississippi", "mis*is*ip*.")
