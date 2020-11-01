# -*- coding: utf-8 -*-
# @Time: 2020/9/28 20:43
# @Author: GraceKoo
# @File: interview_61.py
# @Desc: https://leetcode-cn.com/prdoblems/xu-lie-hua-er-cha-shu-lcof/
from collections import deque


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "[]"
        # 广度优先搜索
        result, de = [], deque()
        de.append(root)
        while de:
            # for _ in range(len(de)):
            #     node = de.popleft()
            #     result.append(node.val)
            #     if node.left:
            #         de.append(node.left)
            #     else:
            #         result.append("null")
            #     if node.right:
            #         de.append(node.right)
            #     else:
            #         result.append("null")
            # 以上可简化为
            node = de.popleft()
            if node:
                result.append(str(node.val))
                de.append(node.left)
                de.append(node.right)
            else:
                result.append("null")

        return "[" + ",".join(result) + "]"

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data == "[]":
            return
        values, i = data[1:-1].split(","), 1  # vals存放所有结点
        root = TreeNode(values[0])
        de = deque()  # 存放各个结点
        de.append(root)
        # 类广度优先遍历，建立结点之间的关系
        while de:
            node = de.popleft()
            if values[i] != "null":
                node.left = TreeNode(int(values[i]))
                de.append(node.left)
            i += 1
            if values[i] != "null":
                node.right = TreeNode(int(values[i]))
                de.append(node.right)
            i += 1
        return root
