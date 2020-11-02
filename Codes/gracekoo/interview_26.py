# -*- coding: utf-8 -*-
# @Time: 2020/6/22 22:33
# @Author: GraceKoo
# @File: interview_26.py
# @Desc: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/


"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""


class Solution:
    # 中序遍历
    def zhongxu(self, root):
        if not root:
            return []
        return self.zhongxu(root.left) + [root] + self.zhongxu(root.right)

    # 将中序遍历结果进行连接
    def treeToDoublyList(self, root: "Node") -> "Node":
        list_result = self.zhongxu(root)
        if len(list_result) == 0 or len(list_result) == 1:
            return root
        for i in range(len(list_result) - 1):
            list_result[i].right = list_result[i + 1]
            list_result[i + 1].left = list_result[i]
        return list_result[0]
