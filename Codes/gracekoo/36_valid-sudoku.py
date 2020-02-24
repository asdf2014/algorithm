# -*- coding: utf-8 -*-
# @Time: 2020/2/3 11:18 下午
# @Author: GraceKoo
# @File: 36_valid-sudoku.py
# @Desc:https://leetcode-cn.com/problems/valid-sudoku/


class Solution:
    def isValidSudoku(self, board) -> bool:
        rows = [{} for i in range(0, 9)]  # rows记录每行的数据情况
        columns = [{} for i in range(0, 9)]  # rows记录每列的数据情况
        boxes = [{} for i in range(0, 9)]  # rows记录每个3*3子块的数据情况

        for row in range(0, 9):
            for column in range(0, 9):
                number = board[row][column]
                if number != ".":
                    number = int(number)
                    box_index = (
                        row // 3
                    ) * 3 + column // 3  # 对应(0,1,2,3,4,5,6,7,8,9)个子单元
                    rows[row][number] = rows[row].get(number, 0) + 1
                    columns[column][number] = columns[column].get(number, 0) + 1
                    boxes[box_index][number] = boxes[box_index].get(number, 0) + 1

                    if (
                        rows[row][number] > 1
                        or columns[column][number] > 1
                        or boxes[box_index][number] > 1
                    ):
                        return False
        return True


so = Solution()
print(
    so.isValidSudoku(
        [
            ["8", "3", ".", ".", "7", ".", ".", ".", "."],
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
print(
    so.isValidSudoku(
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
