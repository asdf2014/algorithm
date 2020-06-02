# -*- coding: utf-8 -*-
# @Time: 2020/6/2 12:32 
# @Author: GraceKoo
# @File: interview_26.py
# @Desc: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSubStructure(self, A: TreeNode, B: TreeNode) -> bool:
        if not A or not B:
            return False
        return self.recure(A, B) or self.isSubStructure(A.left, B) or self.isSubStructure(A.right, B)

    def recure(self, A: TreeNode, B: TreeNode) -> bool:
        if not B:
            return True
        if not A or A.val != B.val:
            return False
        return self.recure(A.left, B.left) and self.recure(A.right, B.right)
