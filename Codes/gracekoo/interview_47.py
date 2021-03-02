# -*- coding: utf-8 -*-
# @Time: 2020/9/24 15:16
# @Author: GraceKoo
# @File: interview_47.py
# @Desc: https://leetcode-cn.com/problems/qiu-12n-lcof/


class Solution:
    def __init__(self):
        self.res = 0

    def sumNums(self, n: int) -> int:
        # 如果n大于1，则and后面的语句继续执行，即，继续递归
        n > 1 and self.sumNums(n - 1)

        # 如果已经不大于1，则程序继续执行下面的语句，进行累加
        self.res += n

        # 最后返回当前累加的结果
        return self.res


so = Solution()
print(so.sumNums(3))
