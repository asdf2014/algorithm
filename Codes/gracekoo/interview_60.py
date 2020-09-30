# -*- coding: utf-8 -*-
# @Time: 2020/9/28 20:43 
# @Author: GraceKoo
# @File: interview_60.py
# @Desc: https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&q
# ru=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 返回二维列表[[1,2],[4,5]]
    def Print(self, pRoot):
        # write code here