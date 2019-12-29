# -*- coding: utf-8 -*-
# @Time: 2019/12/29 5:55 下午
# @Author: GraceKoo
# @File: 17_letter-combinations-of-a-phone-number.py
# @Desc: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/


class Solution:
    def letterCombinations(self, digits: str):
        digit_number_dict = {'2': ['a', 'b', 'c'], '3': ['d', 'e', 'f'], '4': ['g', 'h', 'i'], '5': ['j', 'k', 'l'],
                             '6': ['m', 'n', 'o'], '7': ['p', 'q', 'r', 's'], '8': ['t', 'u', 'v'], '9': ['w', 'x', 'y', 'z']}
        output = []

        def backtrack(combination, next_digits):
            if not next_digits:
                output.append(combination)  # "ap"、"aq"、"ar"......
            else:
                for letter in digit_number_dict[next_digits[0]]:
                    backtrack(combination + letter, next_digits[1:])
        if digits:
            backtrack("", digits)
        return output


so = Solution()
print(so.letterCombinations("27"))

