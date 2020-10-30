# -*- coding: utf-8 -*-
# @Time: 2020/5/10 22:47
# @Author: GraceKoo
# @File: interview_4.py
# @Desc: https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def buildTree(self, preorder, inorder):
        if not preorder:
            return None
        # 前序遍历第一个肯定为根节点
        root_value = preorder[0]
        root = TreeNode(root_value)

        # 根据中序遍历结果确定根节点的左右子树
        root_index = inorder.index(root_value)
        # 在中序列表中的左右子树
        left_in_inorder = inorder[:root_index]
        right_in_inorder = inorder[root_index + 1:]
        # 在前序列表中的左右子树
        left_in_preorder = preorder[1: root_index + 1]  # 左子树数量就是root_index的个数
        right_in_preorder = preorder[root_index + 1:]

        # 递归创建子树
        root.left = self.buildTree(left_in_preorder, left_in_inorder)
        root.right = self.buildTree(right_in_preorder, right_in_inorder)
        return root
