# -*- coding: utf-8 -*-
# @Time: 2020/5/19 23:48 
# @Author: GraceKoo
# @File: 687_longest-univalue-path.py
# @Desc: https://leetcode-cn.com/problems/longest-univalue-path/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def longestUnivaluePath(self, root: TreeNode) -> int:
        self.ans = 0

        def arrow_length(node: TreeNode):
            if node is None:
                return 0
            left_length = arrow_length(node.left)
            right_length = arrow_length(node.right)
            left_arrow = right_arrow = 0
            if node.left and node.val == node.left.val:
                left_arrow = left_length + 1
            if node.right and node.val == node.right.val:
                right_arrow = right_length + 1
            self.ans = max(self.ans, left_arrow+right_arrow)
            return max(left_arrow, right_arrow)
        arrow_length(root)
        return self.ans

