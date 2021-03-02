# -*- coding: utf-8 -*-
# @Time: 2020/4/21 20:38
# @Author: GraceKoo
# @File: 784_letter-case-permutation.py
# @Desc: https://leetcode-cn.com/problems/letter-case-permutation/
from typing import List


class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        result = []

        def helper(s, pre):
            # 递归退出条件
            if not s:
                result.append("".join(pre))
                return
            if s[0].isalpha():
                helper(s[1:], pre + [s[0].upper()])
                helper(s[1:], pre + [s[0].lower()])
            else:
                helper(s[1:], pre + [s[0]])

        helper(S, [])
        return result


so = Solution()
print(so.letterCasePermutation("a1b2"))
