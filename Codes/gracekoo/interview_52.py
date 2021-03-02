# -*- coding: utf-8 -*-
# @Time: 2020/9/25 17:43
# @Author: GraceKoo
# @File: interview_52.py
# @Desc: https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
from functools import lru_cache


class Solution:
    @lru_cache(None)
    def isMatch(self, s: str, p: str) -> bool:
        # 结束条件：如果现在p为空，那匹配结果取决于s是否为空，s为空，返回True
        if not p:
            return not s

        first_match = (len(s) > 0) and p[0] in {s[0], "."}
        # 先处理 `*`
        if len(p) >= 2 and p[1] == "*":
            # 匹配0个 | 多个
            return self.isMatch(s, p[2:]) or (first_match and self.isMatch(s[1:], p))

        # 处理 `.` ，匹配一个
        return first_match and self.isMatch(s[1:], p[1:])


so = Solution()
print(so.isMatch("aab", "a*"))
