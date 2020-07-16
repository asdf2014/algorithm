# -*- coding: utf-8 -*-
# @Time: 2020/7/16 16:43
# @Author: GraceKoo
# @File: interview_18.py
# @Desc: https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 递归
    def mirrorTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        root.left, root.right = root.right, root.left
        self.mirrorTree(root.left)
        self.mirrorTree(root.right)
        return root

    # 迭代
    def mirrorTree_diedai(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        # 广度优先，将节点依次插入
        queue = [root]
        while queue:
            node = queue.pop(0)
            # 先交换
            node.left, node.right = node.right, node.left
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return root
