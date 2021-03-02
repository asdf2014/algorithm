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
    def __init__(self):
        self.k = None
        self.result_node = None

    def kthLargest(self, root: TreeNode, k: int) -> int:
        # 对二叉搜索树进行反中序遍历，将产生一个从大到小的序列
        def dfs(root):
            # 递归结束条件
            if not root or self.k == 0:
                return
            # 先遍历右结点
            dfs(root.right)

            # 对当前结点进行判断，如果当前k已经减到0了，则找到第k大的结点了，返回
            self.k -= 1
            if self.k == 0:
                self.result_node = root.val

            # 再遍历左结点
            dfs(root.left)

        self.k = k
        dfs(root)
        return self.result_node
