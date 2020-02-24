# -*- coding: utf-8 -*-
# @Time: 2019/12/20 11:38 下午
# @Author: GraceKoo
# @File: 9_palindrome_number.py
# @Desc: https://leetcode-cn.com/problems/palindrome-number/


class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        return_num = 0
        # 只对比一半
        while x > return_num:
            return_num = return_num * 10 + x % 10
            x = x // 10
        # x是偶数则相等 奇数要去掉最后一位
        return x == return_num or x == return_num // 10


so = Solution()
print(so.isPalindrome(1221))
