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
            # 先比较当前节点
            # 证明已经越过了叶节点，返回True
            if not LeftNode and not RightNode:
                return True
            # 如果只有一边越过了叶节点，返回False
            if not LeftNode or not RightNode or LeftNode.val != RightNode.val:
                return False
            # 再递归比较叶子节点
            return recur(LeftNode.left, RightNode.right) and recur(
                LeftNode.right, RightNode.left
            )

        return recur(root.left, root.right) if root else True
