# -*- coding: utf-8 -*-
# @Time: 2020/4/12 22:43
# @Author: GraceKoo
# @File: 94_binary-tree-inorder-traversal.py
# @Desc: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []

        def backtrack(root):
            if not root:
                return
            backtrack(root.left)
            res.append(root.val)
            backtrack(root.right)

        backtrack(root)
        return res


root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
so = Solution()
print(so.inorderTraversal(root))
