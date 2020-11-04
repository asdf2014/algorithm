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
    def __init(self):
        self.pre = None
        self.head = None

    def Convert(self, pRootOfTree):
        # write code here
        def dfs(current_node):
            # 递归出口：代表到达尾结点
            if not current_node:
                return
            dfs(current_node.left)

            # 如果pre是空，证明当前访问的是第一个结点
            if not self.pre:
                self.head = current_node
            # 如果不是空，则证明当前结点不是头结点，可进行修改
            else:
                self.pre.right, current_node.left = current_node, self.pre
            # 保存当前结点为pre
            self.pre = current_node

            # 再去递归右子树
            dfs(current_node.right)

        if not pRootOfTree:
            return
        dfs(pRootOfTree)
        # 最后将头结点和尾结点进行连接
        self.pre.right, self.head.left = self.head, self.pre
        return self.head
