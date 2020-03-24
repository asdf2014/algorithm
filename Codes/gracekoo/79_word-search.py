# -*- coding: utf-8 -*-
# @Time: 2020/3/24 21:06 
# @Author: GraceKoo
# @File: 79_word-search.py
# @Desc:https://leetcode-cn.com/problems/word-search/
from typing import List


class Solution:
    derections = [(0, -1), (-1, 0), (0, 1), (1, 0)]

    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        marked = [[False for _ in range(cols)] for _ in range(rows)]
        for row in range(rows):
            for col in range(cols):
                if self.__search_word(board, word, 0, row, col, marked, rows, cols):
                    return True
        return False

    def __search_word(self, board, word, index_word, row, col, marked, rows, cols):
        # 递归终止条件
        if len(word) - 1 == index_word:
            return board[row][col] == word[index_word]
        if board[row][col] == word[index_word]:
            marked[row][col] = True
            for derection in self.derections:
                next_x, next_y = row + derection[0], col + derection[1]
                if 0 <= next_x < rows and 0 <= next_y < cols and not marked[next_x][next_y] \
                    and self.__search_word(board, word,
                                           index_word + 1,
                                           next_x, next_y,
                                           marked, rows, cols):
                    return True
            marked[row][col] = False
        return False


so = Solution()
print(so.exist([
    ['A', 'B', 'C', 'E'],
    ['S', 'F', 'C', 'S'],
    ['A', 'D', 'E', 'E']
], "ABCCED"))
