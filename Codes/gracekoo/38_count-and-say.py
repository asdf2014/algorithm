# -*- coding: utf-8 -*-
# @Time: 2020/1/10 11:39 下午
# @Author: GraceKoo
# @File: 38_count-and-say.py
# @Desc:https://leetcode-cn.com/problems/count-and-say/


class Solution:
    def countAndSay(self, n: int) -> str:
        prev_person = "1"
        for i in range(1, n):
            next_person, num, count = '', prev_person[0], 1
            for j in range(1, len(prev_person)):
                if prev_person[j] == num:
                    count += 1
                else:
                    next_person += str(count) + num
                    num = prev_person[j]
                    count = 1
            next_person += str(count) + num
            prev_person = next_person
        return prev_person


so = Solution()
print(so.countAndSay(3))
