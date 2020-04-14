# -*- coding: utf-8 -*-
# @Time: 2020/4/14 22:59 
# @Author: GraceKoo
# @File: 98_validate-binary-search-tree.py
# @Desc: https://leetcode-cn.com/problems/validate-binary-search-tree/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack = [(root, float('-inf'), float('inf')), ]
        # 深度优先遍历
        while stack:
            root, lower, upper = stack.pop()
            # 防止append一个空子树
            if not root:
                continue
            val = root.val
            if val <= lower or val >= upper:
                return False
            stack.append((root.right, val, upper)) # 右子树的所有值都要大于根节点
            stack.append((root.left, lower, val))  # 左子树的所有值都要小于根节点
        return True
