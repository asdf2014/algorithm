# -*- coding: utf-8 -*-
# @Time: 2020/9/15 20:03
# @Author: GraceKoo
# @File: interview_39.py
# @Desc: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 判断以root为根的二叉树是否平衡
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return (
            abs(self.depth(root.left) - self.depth(root.right)) <= 1
            and self.isBalanced(root.left)
            and self.isBalanced(root.right)
        )

    # 计算以root为根的二叉树的深度
    def depth(self, root):
        if not root:
            return 0
        return max(self.depth(root.left), self.depth(root.right)) + 1
