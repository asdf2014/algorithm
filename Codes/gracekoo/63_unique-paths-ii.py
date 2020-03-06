# -*- coding: utf-8 -*-
# @Time: 2020/3/5 21:51
# @Author: GraceKoo
# @File: 63_unique-paths-ii.py
# @Desc:https://leetcode-cn.com/problems/unique-paths-ii/
from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        row = len(obstacleGrid)
        col = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1:
            return 0
        obstacleGrid[0][0] = 1
        for i in range(1, col):
            obstacleGrid[0][i] = int(
                obstacleGrid[0][i - 1] == 1 and obstacleGrid[0][i] == 0
            )
        for j in range(1, row):
            obstacleGrid[j][0] = int(
                obstacleGrid[j - 1][0] == 1 and obstacleGrid[j][0] == 0
            )
        print(obstacleGrid)

        for i in range(1, row):
            for j in range(1, col):
                if obstacleGrid[i][j] == 1:
                    obstacleGrid[i][j] = 0
                else:
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
        return obstacleGrid[-1][-1]


so = Solution()
print(so.uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]]))
