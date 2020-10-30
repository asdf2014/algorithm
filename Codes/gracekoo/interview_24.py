# -*- coding: utf-8 -*-
# @Time: 2020/6/15 23:03
# @Author: GraceKoo
# @File: interview_24.py
# @Desc: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res, path = [], []  # 用于存放最终的结果，与当前遍历的路径

        # 输入当前的遍历的节点，与当前的目标值
        def recur(root, tar):
            if not root:
                return
            path.append(root.val)
            tar -= root.val
            if tar == 0 and not root.left and not root.right:
                res.append(list(path))
            # 如果已经找到了一条路径，那么下面两行会直接return，所以这样写也没关系
            recur(root.left, tar)
            recur(root.right, tar)
            path.pop()

        recur(root, sum)
        return res

