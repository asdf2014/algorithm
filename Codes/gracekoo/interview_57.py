# -*- coding: utf-8 -*-
# @Time: 2020/5/11 19:47
# @Author: GraceKoo
# @File: interview_57.py
# @Desc: https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class TreeLinkNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None  # 中序遍历序列的下一个节点


class Solution:
    def GetNext(self, pNode):
        # write code here
        if not pNode:
            return None
        # 如果当前节点有右节点，则下一个节点为其右节点的最左侧的节点
        if pNode.right:
            pNode = pNode.right
            while pNode.left:
                pNode = pNode.left
            return pNode
        # 如果当前节点没有右节点
        while pNode.next:
            # 如果当前节点位于左子树上
            if pNode.next.left == pNode:  # pNode.next为父节点
                return pNode.next
            # 否则循环找，直到当前节点为其父节点的左子树
            pNode = pNode.next
        return None
