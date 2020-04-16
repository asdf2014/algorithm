# -*- coding: utf-8 -*-
# @Time: 2020/4/16 22:36
# @Author: GraceKoo
# @File: 99_recover-binary-search-tree.py
# @Desc: https://leetcode-cn.com/problems/recover-binary-search-tree/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.pre_node = TreeNode(float("-inf"))
        self.second_node = None
        self.first_node = None

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # 中序遍历：找到第一个大于左子树的节点赋值为first_node，第一个小于右子树的节点赋值为second_node
        def in_order(root):
            if not root:
                return
            in_order(root.left)
            if self.first_node is None and self.pre_node.val >= root.val:
                self.first_node = self.pre_node
            if self.first_node is not None and self.pre_node.val >= root.val:
                self.second_node = root
            self.pre_node = root
            in_order(root.right)
        in_order(root)
        self.first_node.val, self.second_node.val = self.second_node.val, self.first_node.val
