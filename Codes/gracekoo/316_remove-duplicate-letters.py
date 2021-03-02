# -*- coding: utf-8 -*-
# @Time: 2020/5/17 23:06
# @Author: GraceKoo
# @File: 316_remove-duplicate-letters.py
# @Desc: https://leetcode-cn.com/problems/remove-duplicate-letters/


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        if s == "":
            return s
        stack = []
        value_in_stack = set()
        last_occurance = {k: i for i, k in enumerate(s)}
        for i, c in enumerate(s):
            if c not in value_in_stack:
                # stack[-1] > c:如果栈顶元素的字典序大于当前的c
                # last_occurance[stack[-1]] > i：且栈顶元素还会在后续s中出现
                # 则将栈顶元素弹出，并压入当前元素
                while stack and stack[-1] > c and last_occurance[stack[-1]] > i:
                    value_in_stack.discard(stack.pop())
                stack.append(c)
                value_in_stack.add(c)
        return "".join(stack)


so = Solution()
print(so.removeDuplicateLetters("cbacdcbc"))
