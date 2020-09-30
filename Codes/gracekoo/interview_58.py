# -*- coding: utf-8 -*-
# @Time: 2020/9/28 20:42 
# @Author: GraceKoo
# @File: interview_58.py
# @Desc: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def recur(LeftNode, RightNode):
            if not LeftNode and not RightNode:
                return True
            if not LeftNode or not RightNode or LeftNode.val != RightNode.val:
                return False
            # 不满足直接退出的条件，则继续向下递归
            return recur(LeftNode.left, RightNode.right) and recur(LeftNode.right, RightNode.left)

        return recur(root.left, root.right) if root else True

