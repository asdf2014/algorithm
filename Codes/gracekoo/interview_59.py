# -*- coding: utf-8 -*-
# @Time: 2020/9/28 20:43
# @Author: GraceKoo
# @File: interview_59.py
# @Desc: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
import collections


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def Print(self, pRoot):
        # write code here
        if not pRoot:
            return []
        result, deque = [], collections.deque()
        deque.append(pRoot)
        # 广度优先遍历
        while deque:
            temp = []
            for i in range(len(deque)):
                node = deque.popleft()
                temp.append(node.val)
                if node.left:
                    deque.append(node.left)
                if node.right:
                    deque.append(node.right)
            result.append(temp[::-1] if len(result) % 2 else temp)
        return result
