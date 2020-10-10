# -*- coding: utf-8 -*-
# @Time: 2020/9/28 20:43 
# @Author: GraceKoo
# @File: interview_60.py
# @Desc: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
from collections import deque


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 返回二维列表[[1,2],[4,5]]
    def Print(self, pRoot):
        # write code here
        if not pRoot:
            return []
        #  广度优先遍历
        result, de = [], deque()
        de.append(pRoot)
        while de:
            temp = []
            for _ in range(len(de)):
                node = de.popleft()
                temp.append(node.val)
                if node.left:
                    de.append(node.left)
                if node.right:
                    de.append(node.right)
            result.append(temp)
        return result
