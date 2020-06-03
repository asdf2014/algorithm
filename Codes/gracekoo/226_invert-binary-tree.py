# -*- coding: utf-8 -*-
# @Time: 2020/6/3 12:28 
# @Author: GraceKoo
# @File: 226_invert-binary-tree.py
# @Desc: https://leetcode-cn.com/problems/invert-binary-tree/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return root
        left = self.invertTree(root.left)
        right = self.invertTree(root.right)
        root.left = right
        root.right = left
        return root
