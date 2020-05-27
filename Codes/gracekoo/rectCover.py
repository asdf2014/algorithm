# -*- coding: utf-8 -*-
# @Time: 2020/5/27 12:48
# @Author: GraceKoo
# @File: rectCover.py
# @Desc: https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/
# coding-interviews&qru=/ta/coding-interviews/question-ranking


class Solution:
    def rectCover(self, number):
        # write code here
        if number == 1:
            return 1
        elif number == 2:
            return 2
        return self.rectCover(number - 1) + self.rectCover(number - 2)


so = Solution()
print(so.rectCover(3))
