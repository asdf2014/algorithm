# -*- coding: utf-8 -*-
# @Time: 2020/2/19 15:23
# @Author: GraceKoo
# @File: 48_rotate-image.py
# @Desc:https://leetcode-cn.com/problems/rotate-image/


class Solution:
    def ero_matrics(self, matric):
        if not matric:
            return matric
        # 先转置
        for i in range(0, len(matric)):
            for j in range(i, len(matric)):
                tmp = matric[i][j]
                matric[i][j] = matric[j][i]
                matric[j][i] = tmp
        # 再反转每一行
        for i in range(0, len(matric)):
            for j in range(0, len(matric) // 2):
                tmp = matric[i][j]
                matric[i][j] = matric[i][len(matric) - j - 1]
                matric[i][len(matric) - j - 1] = tmp

        return matric


so = Solution()
print(so.ero_matrics([[4, 8, 12, 16], [3, 7, 11, 15], [2, 6, 10, 14], [1, 5, 9, 13]]))
print(so.ero_matrics([[3, 6, 9], [2, 5, 8], [1, 4, 7]]))
