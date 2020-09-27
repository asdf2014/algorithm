# -*- coding: utf-8 -*-
# @Time: 2020/8/26 20:27 
# @Author: GraceKoo
# @File: interview_38.py
# @Desc: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # 1. DFS
        # if not root:
        #     return 0
        # return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

        # 2. BFS
        if not root:
            return 0
        queue = [root]
        result = 0
        while queue:
            # 遍历每层的结点
            tmp = []
            for node in queue:
                if node.left:
                    tmp.append(node.left)
                if node.right:
                    tmp.append(node.right)
            # 将每层的元素重新赋值给queue
            queue = tmp
            result += 1
        return result
