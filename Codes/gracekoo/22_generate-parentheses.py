# -*- coding: utf-8 -*-
# @Time: 2020/1/2 12:06 下午
# @Author: GraceKoo
# @File: 22_generate-parentheses.py
# @Desc: https://leetcode-cn.com/problems/generate-parentheses/
#       (
#     (    )
#   )        (
# )            )


class Solution:
    def generateParenthesis(self, n: int):
        output_li = []
        def find_Parenthesis(s="",left=0,right=0):
            if len(s) == 2 * n:
                output_li.append(s)
                return
            if left < n:
                find_Parenthesis(s+"(", left+1, right)
            if right < left:
                find_Parenthesis(s+")", left, right+1)
        find_Parenthesis()
        return output_li


so = Solution()
print(so.generateParenthesis(2))

