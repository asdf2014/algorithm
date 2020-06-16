# -*- coding: utf-8 -*-
# @Time: 2020/6/15 23:03
# @Author: GraceKoo
# @File: interview_34.py
# @Desc: https://leetcode-cn.com/problems/
# er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res, path = [], []

        def recur(root, tar):
            if not root:
                return
            path.append(root.val)
            tar -= root.val
            if tar == 0 and not root.left and not root.right:
                res.append(list(path))
            recur(root.left, tar)
            recur(root.right, tar)
            path.pop()

        recur(root, sum)
        return res
