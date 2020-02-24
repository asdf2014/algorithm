# -*- coding: utf-8 -*-
# @Time: 2020/2/10 2:57 下午
# @Author: GraceKoo
# @File: 40_combination-sum-ii.py
# @Desc: https://leetcode-cn.com/problems/combination-sum-ii/

from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
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

            if index > begin and candidates[index - 1] == candidates[index]:
                continue
            path.append(candidates[index])
            self._dfs(candidates, index + 1, size, path, output_list, residue)
            path.pop()


if __name__ == "__main__":
    candidates = [2, 5, 2, 1, 2]
    target = 5
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
