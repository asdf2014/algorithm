# -*- coding: utf-8 -*-
# @Time: 2020/2/24 13:55
# @Author: GraceKoo
# @File: 51_n-queens.py
# @Desc:https://leetcode-cn.com/problems/n-queens/
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # 判断当前位置是否可用，由当前列，主对角线，副对角线共同决定
        def could_place(row, col):
            return not cols[col] + main_diagonals[row - col] + counter_diagonals[row + col]

        # 放置皇后
        def place_queen(row, col):
            queens_position.add((row, col))
            cols[col] = 1
            main_diagonals[row - col] = 1
            counter_diagonals[row + col] = 1

        # 消除皇后
        def remove_queen(row, col):
            queens_position.remove((row, col))
            cols[col] = 0
            main_diagonals[row - col] = 0
            counter_diagonals[row + col] = 0

        # 增加解
        def add_solution():
            solution = []
            for _, col in sorted(queens_position):
                solution.append('.' * col + 'Q' + '.' * (n - col - 1))
            output.append(solution)

        def backtrack(row=0):
            for col in range(n):
                if could_place(row, col):
                    place_queen(row, col)
                    if row + 1 == n:
                        add_solution()
                    else:
                        backtrack(row + 1)
                    remove_queen(row, col)
        cols = [0] * n  # 每列的Queen
        main_diagonals = [0] * (2 * n - 1)  # 共需要7个元素可以表示全部的主对角线元素
        counter_diagonals = [0] * (2 * n - 1)  # 共需要7个元素可以表示全部的副对角线元素
        queens_position = set() # 用于记录当前已经摆放的位置
        output = []
        backtrack()
        return output


so = Solution()
print(so.solveNQueens(4))
