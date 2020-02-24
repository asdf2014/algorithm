# -*- coding: utf-8 -*-
# @Time: 2020/2/24 19:35
# @Author: GraceKoo
# @File: 52_n-queens-ii.py
# @Desc:https://leetcode-cn.com/problems/n-queens-ii/
from typing import List


class Solution:
    def totalNQueens(self, n: int) -> int:
        # 判断当前位置是否可用，由当前列，主对角线，副对角线共同决定
        def could_place(row, col):
            return (
                not cols[col] + main_diagonals[row - col] + counter_diagonals[row + col]
            )

        # 放置皇后
        def place_queen(row, col):
            cols[col] = 1
            main_diagonals[row - col] = 1
            counter_diagonals[row + col] = 1

        # 消除皇后
        def remove_queen(row, col):
            cols[col] = 0
            main_diagonals[row - col] = 0
            counter_diagonals[row + col] = 0

        def backtrack(row=0, output = 0):
            for col in range(n):
                if could_place(row, col):
                    place_queen(row, col)
                    if row + 1 == n:
                        output += 1
                    else:
                        output = backtrack(row + 1, output)
                    remove_queen(row, col)
            return output

        cols = [0] * n  # 每列的Queen
        main_diagonals = [0] * (2 * n - 1)  # 共需要7个元素可以表示全部的主对角线元素
        counter_diagonals = [0] * (2 * n - 1)  # 共需要7个元素可以表示全部的副对角线元素
        return backtrack()


so = Solution()
print(so.totalNQueens(4))
