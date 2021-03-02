# -*- coding: utf-8 -*-
# @Time: 2020/4/14 12:28
# @Author: GraceKoo
# @File: 95_unique-binary-search-trees-ii.py
# @Desc:https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        def generate_tree(start, end):
            if start > end:
                return [
                    None,
                ]
            all_trees = []

            # pick a root
            for i in range(start, end + 1):
                left_tree = generate_tree(start, i)
                right_tree = generate_tree(i + 1, end)
                for left in left_tree:
                    for right in right_tree:
                        current_tree = TreeNode(i)
                        current_tree.left = TreeNode(left)
                        current_tree.right = TreeNode(right)
                        all_trees.append(current_tree)
            return all_trees

        return generate_tree(1, n) if n else []
