# -*- coding: utf-8 -*-
# @Time: 2020/2/9 11:55 上午 
# @Author: GraceKoo
# @File: 39_combination-sum.py
# @Desc: https://leetcode-cn.com/problems/combination-sum/solution/

from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates or not target:
            return []
        candidates.sort()
        output_list = []
        path = []
        begin = 0
        size = len(candidates)
        self._dfs(candidates, begin, size, path, output_list, target)
        return output_list

    def _dfs(self, candidates, begin, size, path, output_list, target):
        # 递归终止的条件
        if target == 0:
            output_list.append(path[:])
        for index in range(begin, size):
            residue = target - candidates[index]
            if residue < 0:
                break
            path.append(candidates[index])
            self._dfs(candidates, index, size, path, output_list, residue)
            path.pop()


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    target = 7
    solution = Solution()
    result = solution.combinationSum(candidates, target)
    print(result)
