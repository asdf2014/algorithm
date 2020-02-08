# -*- coding: utf-8 -*-
# @Time: 2020/2/5 9:44 上午
# @Author: GraceKoo
# @File: 37_sudoku-solver.py
# @Desc:https://leetcode-cn.com/problems/sudoku-solver/
from collections import defaultdict


class Solution:
    def solveSudoku(self, board) -> None:
        rows_available = [set(range(1, 10)) for _ in range(9)]  # 行剩余可用数字
        columns_available = [set(range(1, 10)) for _ in range(9)]  # 列剩余可用数字
        boxes_available = [set(range(1, 10)) for _ in range(9)]  # 块剩余可用数字

        # 根据board数据统计每行每列可用的数字
        empty = []
        for row in range(9):
            for column in range(9):
                if board[row][column] == ".":
                    empty.append((row, column))
                else:
                    num = int(board[row][column])
                    rows_available[row].remove(num)
                    columns_available[column].remove(num)
                    boxes_available[(row // 3) * 3 + column // 3].remove(num)

        # 回溯函数，如果当前添加的数字个数已经等于空格的个数，则证明已添加到最后一个空格，即找到答案
        def backtrack(interation=0):
            if interation == len(empty):
                return True
            i, j = empty[interation]  # 依次取出待填入空格的坐标
            for value in (
                rows_available[i]
                & columns_available[j]
                & boxes_available[(i // 3) * 3 + j // 3]
            ):
                rows_available[i].remove(value)
                columns_available[j].remove(value)
                boxes_available[(i // 3) * 3 + j // 3].remove(value)
                board[i][j] = value
                if backtrack(interation + 1):
                    return True
                # 如果没找到答案，则进行回溯
                rows_available[i].add(value)
                columns_available[j].add(value)
                boxes_available[(i // 3) * 3 + j // 3].add(value)
            return False

        backtrack()
        return board


so = Solution()
print(
    so.solveSudoku(
        [
            ["5", "3", ".", ".", "7", ".", ".", ".", "."],
            ["6", ".", ".", "1", "9", "5", ".", ".", "."],
            [".", "9", "8", ".", ".", ".", ".", "6", "."],
            ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
            ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
            ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
            [".", "6", ".", ".", ".", ".", "2", "8", "."],
            [".", ".", ".", "4", "1", "9", ".", ".", "5"],
            [".", ".", ".", ".", "8", ".", ".", "7", "9"],
        ]
    )
)
