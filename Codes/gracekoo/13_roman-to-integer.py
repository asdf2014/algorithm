# -*- coding: utf-8 -*-
# @Time: 2019/12/25 7:43 下午
# @Author: GraceKoo
# @File: 13_roman-to-integer.py
# @Desc: https://leetcode-cn.com/problems/roman-to-integer/


class Solution:
    def romanToInt(self, s):
        output = 0
        roman_dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50,'C': 100, 'D': 500, 'M': 1000}
        for i in range(len(s)):
            if i < len(s) - 1 and roman_dict[s[i]] < roman_dict[s[i+1]]:
                output -= roman_dict[s[i]]
            else:
                output += roman_dict[s[i]]
        return output


so = Solution()
print(so.romanToInt("MCMXCIV"))  # 1994

