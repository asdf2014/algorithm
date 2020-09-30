# -*- coding: utf-8 -*-
# @Time: 2020/9/28 20:43 
# @Author: GraceKoo
# @File: interview_62.py
# @Desc: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthLargest(self, root: TreeNode, k: int) -> int:
