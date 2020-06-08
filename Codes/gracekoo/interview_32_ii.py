# -*- coding: utf-8 -*-
# @Time: 2020/6/8 19:28
# @Author: GraceKoo
# @File: interview_32_ii.py
# @Desc: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
from typing import List
import collections


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        res, deque = [], collections.deque()
        deque.append(root)
        while deque:
            tem = []
            for _ in range(len(deque)):
                node = deque.popleft()
                tem.append(node.val)
                if node.left:
                    deque.append(node.left)
                if node.right:
                    deque.append(node.right)
            res.append(tem)
        return res
