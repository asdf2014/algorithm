# -*- coding: utf-8 -*-
# @Time: 2020/4/16 12:29
# @Author: GraceKoo
# @File: 100_same-tree.py
# @Desc: https://leetcode-cn.com/problems/same-tree/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return True
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
