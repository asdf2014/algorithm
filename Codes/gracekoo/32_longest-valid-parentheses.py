# -*- coding: utf-8 -*-
# @Time: 2020/1/21 12:58 下午 
# @Author: GraceKoo
# @File: 32_longest-valid-parentheses.py
# @Desc: https://leetcode-cn.com/problems/longest-valid-parentheses/


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not s or len(s) == 1:
            return 0
        maxlen = 0
        # 当前字符为"("，left+=1,")"right+=1

        # 正向搜索: 即")"必须与"("相同
        left, right = 0, 0
        for i in range(len(s)):
            if s[i] == "(":
                left += 1
            else:
                right += 1
            if left == right:
                maxlen = right * 2 if maxlen < right * 2 else maxlen
            elif right > left:
                left = right = 0

        # 反向搜索：即"("必须与")"相同
        left, right = 0, 0
        for i in range(len(s)-1, -1, -1):
            if s[i] == "(":
                left += 1
            else:
                right += 1
            if left == right:
                maxlen = left * 2 if maxlen < left * 2 else maxlen
            elif left > right:
                left = right = 0

        return maxlen


so = Solution()
print(so.longestValidParentheses("())((())"))
