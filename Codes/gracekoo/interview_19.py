# -*- coding: utf-8 -*-
# @Time: 2020/7/16 17:32
# @Author: GraceKoo
# @File: interview_19.py
# @Desc: https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking
from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # 生成器
        def spiral_matrix(r1, c1, r2, c2):
            for c in range(c1, c2 + 1):
                yield r1, c
            for r in range(r1 + 1, r2 + 1):
                yield r, c2
            # 如果r1==r2,或者c1==c2证明已经行或列已有重合，上面已经输出过了，无需重复输出
            if r1 < r2 and c1 < c2:
                for c in range(c2 - 1, c1, -1):
                    yield r2, c
                for r in range(r2, r1, -1):
                    yield r, c1

        if not matrix:
            return []
        output = []
        r1, r2 = 0, len(matrix) - 1
        c1, c2 = 0, len(matrix[0]) - 1
        # 控制大局（矩形范围）：r1、r2、c1、c2
        while r1 <= r2 and c1 <= c2:
            # 用for去遍历这个生成器
            for r, c in spiral_matrix(r1, c1, r2, c2):
                output.append(matrix[r][c])
            r1 += 1
            r2 -= 1
            c1 += 1
            c2 -= 1
        return output


so = Solution()
print(so.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
