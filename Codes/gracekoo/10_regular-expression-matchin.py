# -*- coding: utf-8 -*-
# @Time: 2019/12/21 7:46 下午
# @Author: GraceKoo
# @File: 10_regular-expression-matchin.py
# @Desc:https://leetcode-cn.com/problems/regular-expression-matching/


class Solution(object):
    def isMatch(self, s, p):
        if not p:
            return not s  # 结束条件

        first_match = (len(s) > 0) and p[0] in {s[0], "."}
        # 先处理 `*`
        if len(p) >= 2 and p[1] == "*":
            # 匹配0个 | 多个
            return self.isMatch(s, p[2:]) or (first_match and self.isMatch(s[1:], p))

        # 处理 `.` ，匹配一个
        return first_match and self.isMatch(s[1:], p[1:])


so = Solution()
assert so.isMatch("mississippi", "mis*is*ip*.")
