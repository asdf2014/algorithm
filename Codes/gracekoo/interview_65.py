# -*- coding: utf-8 -*-
# @Time: 2020/10/10 11:58
# @Author: GraceKoo
# @File: interview_65.py
# @Desc: https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(i, j, k):
            # 递归异常退出的条件：索引超出范围或者与当前字母不匹配
            if not 0 <= i < len(board) or not 0 <= j < len(board[0]) or word[k] != board[i][j] or board[i][j] == "*":
                return False
            # 递归成功退出的条件
            if k == len(word)-1:
                return True

            # 继续向上下左右进行遍历
            tmp = board[i][j]
            board[i][j] = "*"  # *表示已经遍历过

            result = dfs(i-1, j, k+1) or dfs(i+1, j, k+1) or dfs(i, j-1, k+1) or dfs(i, j+1, k+1)

            board[i][j] = tmp  # 不管遍历结果如何，都需要恢复相应字符
            return result

        # 从不同的起点出发, k代表当前遍历到的单词字母的索引
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0):
                    return True
        return False
